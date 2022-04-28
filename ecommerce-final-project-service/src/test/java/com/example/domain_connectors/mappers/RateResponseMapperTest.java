package com.example.domain_connectors.mappers;

import com.example.domain.domain.Rate;
import com.example.inbounds.rest.dtos.RateResponseDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateResponseMapperTest {

  RateResponseMapper mapper = Mappers.getMapper(RateResponseMapper.class);

  @Test
  void test_mapper() {

    Rate vo = new Rate("1", "2", "3", LocalDateTime.of(2020, 6, 28, 12, 32, 2), LocalDateTime.of(2021, 7, 29, 13, 33, 3), 1,
        BigDecimal.valueOf(25.45), "EUR");

    RateResponseDTO dto = mapper.mapResponse(vo);

    assertEquals("1", dto.getRateId());
    assertEquals("2", dto.getBrandId());
    assertEquals("3", dto.getProductId());
    assertEquals(LocalDateTime.of(2020, 6, 28, 12, 32, 2), dto.getStartDate());
    assertEquals(LocalDateTime.of(2021, 7, 29, 13, 33, 3), dto.getEndDate());
    assertEquals(BigDecimal.valueOf(25.45), dto.getPrice());
  }
}