package com.salesianostriana.dam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.salesianostriana.dam.dto.CreateUserDto;
import com.salesianostriana.dam.service.UserEntityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner init(UserEntityService userEntityService) {
		return args -> {
			userEntityService.newUserEntity(CreateUserDto.builder()
					.username("user")
					.password("user")
					.password2("user")
					.build());
		};
	}

}
