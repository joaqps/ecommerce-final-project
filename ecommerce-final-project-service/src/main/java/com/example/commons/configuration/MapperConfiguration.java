package com.example.commons.configuration;

import com.example.commons.format.FormatUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

  @Bean
  public ObjectMapper getMapper() {
    return FormatUtils.getMapper();
  }
}
