package com.example.outbound_connectors.mappers;

import com.example.domain.domain.Rate;
import com.example.outbounds.mongo.entities.RateEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RateEntityMapperTest {

  RateEntityMapper mapper = Mappers.getMapper(RateEntityMapper.class);

  @Test
  void test_mapper() {

    RateEntity entity = new RateEntity("1", "2", "3", LocalDateTime.of(2020, 6, 28, 12, 32, 2), LocalDateTime.of(2021, 7, 29, 13, 33, 3), 1,
        BigDecimal.valueOf(25.45), "EUR");

    Rate vo = mapper.mapEntity(entity);

    assertEquals("1", vo.getId());
    assertEquals("2", vo.getBrandId());
    assertEquals("3", vo.getProductId());
    assertEquals(LocalDateTime.of(2020, 6, 28, 12, 32, 2), vo.getStartDate());
    assertEquals(LocalDateTime.of(2021, 7, 29, 13, 33, 3), vo.getEndDate());
    assertEquals(BigDecimal.valueOf(25.45), vo.getPrice());
  }
}