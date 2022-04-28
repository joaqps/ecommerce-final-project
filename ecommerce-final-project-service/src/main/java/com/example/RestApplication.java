package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SuppressWarnings("HideUtilityClassConstructor")
@SpringBootApplication
@EnableMongoRepositories
public class RestApplication {

  public static void main(final String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }
}
