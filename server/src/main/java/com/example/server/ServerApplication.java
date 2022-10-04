package com.example.server;

import com.example.server.enumeration.Status;
import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(null,"192.168.1.160",
					"Prod","64 GB", "Production Environment Server",
					"http://localhost:8080/server/image/s1.png", Status.SERVER_UP));
			serverRepository.save(new Server(null,"192.168.1.58",
					"QA","64 GB", "QA Environment Server",
					"http://localhost:8080/server/image/s2.png", Status.SERVER_UP));
			serverRepository.save(new Server(null,"192.168.1.21",
					"Test","32 GB", "Test Environment Server",
					"http://localhost:8080/server/image/s2.png", Status.SERVER_UP));
			serverRepository.save(new Server(null,"192.168.1.14",
					"UAT","32 GB", "UAT Environment Server",
					"http://localhost:8080/server/image/s3.png", Status.SERVER_UP));
		};
	}


}
