package com.example.inbounds.rest.configuration;

import com.example.commons.format.FormatUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiConfigurationTest {

  ApiConfiguration apiConfiguration = new ApiConfiguration();

  @Test
  void test_beans() {
    Assertions.assertNotNull(apiConfiguration.apiInfo());
    Assertions.assertNotNull(apiConfiguration.restJsonMapper(FormatUtils.getMapper()));
  }
}