package com.softuni.movietopia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MovietopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovietopiaApplication.class, args);
	}

}
