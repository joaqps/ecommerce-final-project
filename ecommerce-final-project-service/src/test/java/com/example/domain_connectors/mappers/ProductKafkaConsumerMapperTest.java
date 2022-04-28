package com.example.domain_connectors.mappers;

import com.example.commons.format.FormatUtils;
import com.example.domain.domain.Product;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductKafkaConsumerMapperTest {

  ProductKafkaConsumerMapper mapper = new ProductKafkaConsumerMapperImpl();

  @BeforeEach
  void init() {
    mapper.setMapper(FormatUtils.getMapper());
  }

  @Test
  void test_date_mapper() {

    ProductKafkaDTO dto = new ProductKafkaDTO("1", "name", "category", "2022-04-26 10:30:00");

    Product vo = mapper.of(dto);

    assertEquals("1", vo.getId());
    assertEquals("name", vo.getName());
    assertEquals("category", vo.getCategory());
    assertEquals(LocalDateTime.of(2022, 4, 26, 10, 30, 0), vo.getEndOfSaleDate());
  }
}