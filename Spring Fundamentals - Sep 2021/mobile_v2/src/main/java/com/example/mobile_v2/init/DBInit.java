package com.example.mobile_v2.init;

import com.example.mobile_v2.model.BrandEntity;
import com.example.mobile_v2.model.CategoryEnum;
import com.example.mobile_v2.model.ModelEntity;
import com.example.mobile_v2.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository  brandRepository;

    public DBInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) {
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

            ford.setModels(List.of(fiesta,escort));
            fiesta.setBrand(ford);
            escort.setBrand(ford);

            brandRepository.save(ford);
        }
    }
}
