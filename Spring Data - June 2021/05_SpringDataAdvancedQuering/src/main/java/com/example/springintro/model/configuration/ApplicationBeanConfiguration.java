package com.example.springintro.model.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//за да стане този клас конфигурационнен -> анотация Configuration
@Configuration
public class ApplicationBeanConfiguration {

    //Създаване на Bean (през метод) : искаме когато се поиска нов BufferReader да
    // се injectne някъде (примерно през конструктор) искаме да върнем нова инстанция
    //само, че тук създаваме инстанцията веднъж и всеки един клас който се нуждае от нея
    //
    @Bean
    public BufferedReader bufferedReader () {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
