package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, PictureService pictureService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files
                .readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder sb = new StringBuilder();

        UserSeedDto[] userSeedDtos = gson.fromJson(readFromFileContent(), UserSeedDto[].class);

        Arrays.stream(userSeedDtos)
                .filter(userSeedDto -> {
                    boolean isValid = validationUtil.isValid(userSeedDto)
                            && !isEntityExists(userSeedDto.getUsername())
                            && pictureService.isEntityExists(userSeedDto.getProfilePicture());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported User: %s", userSeedDto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(userSeedDto -> {
                    User user = modelMapper.map(userSeedDto, User.class);
                    user.setProfilePicture(pictureService.findByPath(userSeedDto.getProfilePicture()));
                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString().trim();
    }

    @Override
    public boolean isEntityExists(String username) {
        return userRepository
                .existsByUsername(username);
    }

    @Override
    public String exportUsersWithTheirPosts() {

        StringBuilder sb = new StringBuilder();
        userRepository
                .findAllByPostsCountDescThenByUserId()
                .forEach(user -> {
                    sb
                            .append(String.format("\n" +
                                    "\"User: %s\n" +
                                    "Post count: %d\n",
                                    user.getUsername(), user.getPosts().size()));

                    user.getPosts()
                            .forEach(post -> {
                                sb
                                        .append(String.format("""
                                                "==Post Details:"
                                                "----Caption: %sn"
                                                "----Picture Size: %.2f
                                                """,
                                                post.getCaption(), post.getPicture().getSize()));
                            });
                });

        return sb.toString().trim();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}