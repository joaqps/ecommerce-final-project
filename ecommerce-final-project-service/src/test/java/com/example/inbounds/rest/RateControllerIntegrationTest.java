package com.example.inbounds.rest;

import com.example.inbounds.rest.dtos.RateQueryDTO;
import com.example.inbounds.rest.dtos.RateResponseDTO;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RateControllerIntegrationTest {

  @Autowired
  RateController controller;

  @Test
  void tests() {

    test_query(LocalDateTime.of(2020, 6, 14, 10, 0), "1");
    test_query(LocalDateTime.of(2020, 6, 14, 16, 0), "2");
    test_query(LocalDateTime.of(2020, 6, 14, 21, 0), "1");
    test_query(LocalDateTime.of(2020, 6, 15, 10, 0), "3");
    test_query(LocalDateTime.of(2020, 6, 16, 21, 0), "4");
  }

  private void test_query(LocalDateTime date, String expectedId) {

    RateQueryDTO params = new RateQueryDTO("35455", "1", date);

    ResponseEntity<SimpleResponseDto<RateResponseDTO>> response = controller.findByProductIdBrandIdAndDate(params);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertNotNull(response.getBody().getData());
    assertEquals(expectedId, response.getBody().getData().getRateId());
  }

}
