package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@EnableDiscoveryClient
@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(UsersApplication.class, args);

		// UserService userService = context.getBean(UserService.class);
		//
		// userService.save("juan@email.com", "123456");
	}
}
