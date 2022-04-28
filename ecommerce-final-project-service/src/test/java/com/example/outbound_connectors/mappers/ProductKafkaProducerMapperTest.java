package com.example.outbound_connectors.mappers;

import com.example.commons.format.FormatUtils;
import com.example.domain.domain.Product;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductKafkaProducerMapperTest {

  ProductKafkaProducerMapper mapper = new ProductKafkaProducerMapperImpl();

  @BeforeEach
  void init() {
    mapper.setMapper(FormatUtils.getMapper());
  }

  @Test
  void test_mapper() {

    Product vo = new Product("1", "name", "category", LocalDateTime.of(2022, 4, 26, 10, 30, 0), LocalDateTime.of(2021, 5, 27, 11, 31, 1),
        LocalDateTime.of(2020, 6, 28, 12, 32, 2));

    ProductKafkaDTO dto = mapper.of(vo);

    assertEquals("1", dto.getId());
    assertEquals("name", dto.getName());
    assertEquals("category", dto.getCategory());
    assertEquals("2022-04-26 10:30:00", dto.getEndOfSaleDate());
  }
}