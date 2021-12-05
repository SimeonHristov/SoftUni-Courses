package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.entities.UserRoleEntity;
import com.softuni.movietopia.model.entities.enums.UserRole;
import com.softuni.movietopia.model.service.UserRegistrationServiceModel;
import com.softuni.movietopia.repository.UserRepository;
import com.softuni.movietopia.repository.UserRoleRepository;
import com.softuni.movietopia.service.UserService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRegService userRegService;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper,
                           UserRegService userRegService,
                           PasswordEncoder encoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRegService = userRegService;
        this.encoder = encoder;
    }


    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));

            UserEntity admin = new UserEntity().setUsername("admin").setFullname("admin admin").setPassword(passwordEncoder.encode("admin"));
            UserEntity user = new UserEntity().setUsername("user").setFullname("user user").setPassword(passwordEncoder.encode("userr"));
            admin.setRoles(List.of(adminRole, userRole));
            user.setRoles(List.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {
        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository.
                findByRole(UserRole.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUser.addRole(userRole);

        newUser = userRepository.save(newUser);

        UserDetails principal = userRegService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findByName(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

    }
}
