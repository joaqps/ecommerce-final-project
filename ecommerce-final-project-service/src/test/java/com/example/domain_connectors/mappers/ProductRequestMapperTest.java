package com.example.domain_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductRequestMapperTest {

  ProductRequestMapper mapper = Mappers.getMapper(ProductRequestMapper.class);

  @Test
  void test_mapper() {

    ProductRequestDTO dto = new ProductRequestDTO("1", "name", "category", LocalDateTime.of(2022, 4, 26, 10, 30, 0));

    Product vo = mapper.mapRequest(dto);

    assertEquals("1", vo.getId());
    assertEquals("name", vo.getName());
    assertEquals("category", vo.getCategory());
    assertEquals(LocalDateTime.of(2022, 4, 26, 10, 30, 0), vo.getEndOfSaleDate());
  }
}