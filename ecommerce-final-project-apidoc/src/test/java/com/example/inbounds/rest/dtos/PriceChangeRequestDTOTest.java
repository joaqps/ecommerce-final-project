package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceChangeRequestDTOTest {

  @Test
  void test_fields() {

    PriceChangeRequestDTO dto = new PriceChangeRequestDTO();
    dto.setRateId("1");
    dto.setPrice(BigDecimal.ONE);

    assertEquals("1", dto.getRateId());
    assertEquals(BigDecimal.ONE, dto.getPrice());
//    RestDtoTester.test(dto, PriceChangeRequestDTO.JSON_TYPE_REF);
  }
}