package com.example.inbounds.rest.configuration;

import com.example.inbounds.rest.apidoc.RatesApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.service.ApiInfo;

@Configuration
public class ApiConfiguration {

  @Bean
  public ApiInfo apiInfo() {
    return RatesApi.buildApiInfo();
  }

  @Bean("ApiConfiguration.restJsonMapper")
  @Primary
  public MappingJackson2HttpMessageConverter restJsonMapper(ObjectMapper mapper) {
    return new MappingJackson2HttpMessageConverter(mapper);
  }

}
