package com.example;

import com.example.domain_connectors.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SuppressWarnings("HideUtilityClassConstructor")
@SpringBootApplication
@EnableMongoRepositories
public class RestApplication {

  public static void main(final String[] args) {

    ApplicationContext context = SpringApplication.run(RestApplication.class, args);

    UserService userService = context.getBean(UserService.class);

    userService.saveUser("juan@email.com", "123456");
  }
}
