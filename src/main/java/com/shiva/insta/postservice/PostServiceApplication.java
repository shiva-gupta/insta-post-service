package com.shiva.insta.postservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.shiva.insta.postservice.config.StorageProperties;
import com.shiva.insta.postservice.services.PostService;

@SpringBootApplication
@EnableConfigurationProperties({ StorageProperties.class })
public class PostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(PostService postService) {
		return (args) -> {
			postService.initDir();
		};
	}

}
