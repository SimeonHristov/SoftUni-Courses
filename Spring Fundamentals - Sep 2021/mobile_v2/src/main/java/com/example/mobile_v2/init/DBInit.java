package com.example.mobile_v2.init;

import com.example.mobile_v2.model.entity.BrandEntity;
import com.example.mobile_v2.model.entity.UserEntity;
import com.example.mobile_v2.model.entity.enums.CategoryEnum;
import com.example.mobile_v2.model.entity.ModelEntity;
import com.example.mobile_v2.repository.BrandRepository;
import com.example.mobile_v2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        initializeBrandsAndModels();
        initializeUsers();
    }

    private void initializeUsers() {

        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin.setActive(true).
                    setUsername("admin").
                    setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("test"));
            userRepository.save(admin);
        }
    }

    private void initializeBrandsAndModels() {
        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity().setName("Ford");

            ModelEntity fiesta = new ModelEntity();
            fiesta.setName("Fiesta")
                    .setImageUrl("https://en.wikipedia.org/wiki/File:2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                    .setStarYear(1976)
                    .setCategory(CategoryEnum.CAR);

            ModelEntity escort = new ModelEntity();
            escort.setName("Escort")
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Ford_Escort_MkI_1100_1972.JPG/280px-Ford_Escort_MkI_1100_1972.JPG")
                    .setStarYear(1968)
                    .setEndYear(2002)
                    .setCategory(CategoryEnum.CAR);

            ford.setModels(List.of(fiesta, escort));
            fiesta.setBrand(ford);
            escort.setBrand(ford);

            brandRepository.save(ford);
        }
    }
}
