package com.ismail.live;

import com.ismail.live.model.User;
import com.ismail.live.service.UserService;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			UserService userService
	)
	{
		return args -> {

			userService.register(User.builder()
					.email("ismailbenkraiem27@gmail.com")
					.password("12345")
					.username("ismail")
					.build());
			userService.register(User.builder()
					.email("tarek@gmail.com")
					.password("12345")
					.username("tarek")
					.build());
			userService.register(User.builder()
					.email("ismail@gmail.com")
					.password("12345")
					.username("ismailbk")
					.build());
		};
	}
}
