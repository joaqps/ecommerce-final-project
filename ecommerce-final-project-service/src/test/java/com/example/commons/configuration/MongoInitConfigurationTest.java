package com.example.commons.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

class MongoInitConfigurationTest {

  MongoTemplate mongoTemplate = new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/ecommerce"));
  MongoInitConfiguration mongoInitConfiguration = new MongoInitConfiguration();

  @Test
  void getRepositoryPopulator() {
    Assertions.assertNotNull(mongoInitConfiguration.getRepositoryPopulator(mongoTemplate, new ObjectMapper()));
  }
}