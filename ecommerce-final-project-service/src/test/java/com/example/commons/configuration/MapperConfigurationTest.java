package com.example.commons.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapperConfigurationTest {

  MapperConfiguration mapperConfiguration = new MapperConfiguration();

  @Test
  void test_beans() {
    Assertions.assertNotNull(mapperConfiguration.getMapper());
  }
}