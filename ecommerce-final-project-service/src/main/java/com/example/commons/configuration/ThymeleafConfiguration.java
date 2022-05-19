package com.example.commons.configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfiguration {

  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}
