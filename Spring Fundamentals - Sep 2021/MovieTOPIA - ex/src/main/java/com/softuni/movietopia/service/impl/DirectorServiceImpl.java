package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.model.entities.DirectorEntity;
import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.service.DirectorServiceModel;
import com.softuni.movietopia.repository.DirectorRepository;
import com.softuni.movietopia.repository.UserRepository;
import com.softuni.movietopia.service.DirectorService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public DirectorServiceImpl(
            DirectorRepository directorRepository,
            UserRepository userRepository, ModelMapper modelMapper) {
        this.directorRepository = directorRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<String> findAllDirectors() {
        return directorRepository
                .findAllDirectorNames();
    }

    @Override
    public void seedDirectors() {
        if (directorRepository.count() == 0) {

            DirectorEntity quentinTarantino = new DirectorEntity();
            quentinTarantino.
                setName("Quentin Tarantino").
                    setBio(
                    "Quentin Jerome Tarantino is an American film director, screenwriter, producer, film critic, and actor. His films "
                    + "are characterized by nonlinear storylines, dark humor, stylized violence, extended dialogue, ensemble casts, "
                        + "references to popular culture, alternate history, and neo-noir.");

            DirectorEntity christopherNolan = new DirectorEntity();
            christopherNolan.
                setName("Christopher Nolan").
                    setBio(
                    "Christopher Edward Nolan CBE is a British-American film director, producer, and screenwriter. "
                        + "His films have grossed more than US$5 billion worldwide, and have garnered 11 Academy Awards from 36 "
                        + "nominations. Born and raised in London, Nolan developed an interest in filmmaking from a young age.");


            DirectorEntity jamesCameron = new DirectorEntity();
            jamesCameron.
                setName("James Cameron").
                    setBio(
                    "James Francis Cameron CC is a Canadian filmmaker. Best known for making science fiction and epic films, "
                        + "he first gained recognition for directing The Terminator. He found further success with Aliens, The "
                        + "Abyss, Terminator 2: Judgment Day, and the action comedy True Lies.");


            directorRepository.save(quentinTarantino);
            directorRepository.save(christopherNolan);
            directorRepository.save(jamesCameron);
        }
    }

    @Override
    public DirectorEntity findByName(String director) {
        return directorRepository
                .findByName(director)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void addDirector(DirectorServiceModel serviceModel) {
        DirectorEntity directorEntity = modelMapper.map(serviceModel, DirectorEntity.class);
        UserEntity creator = userRepository.
                findByUsername(serviceModel.getUser()).
                orElseThrow(() -> new IllegalArgumentException("Creator " + serviceModel.getUser() + " could not be found"));
        directorEntity.setUserEntity(creator);

        directorRepository.save(directorEntity);

    }
}
