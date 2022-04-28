package com.example.domain_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.inbounds.rest.dtos.ProductResponseDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductResponseMapperTest {

  ProductResponseMapper mapper = Mappers.getMapper(ProductResponseMapper.class);

  @Test
  void test_mapper() {

    Product vo = new Product("1", "name", "category", LocalDateTime.of(2022, 4, 26, 10, 30, 0), LocalDateTime.of(2021, 5, 27, 11, 31, 1),
        LocalDateTime.of(2020, 6, 28, 12, 32, 2));

    ProductResponseDTO dto = mapper.mapResponse(vo);

    assertEquals("1", dto.getId());
    assertEquals("name", dto.getName());
    assertEquals("category", dto.getCategory());
    assertEquals(LocalDateTime.of(2022, 4, 26, 10, 30, 0), dto.getEndOfSaleDate());
    assertEquals(LocalDateTime.of(2021, 5, 27, 11, 31, 1), dto.getCreatedAt());
    assertEquals(LocalDateTime.of(2020, 6, 28, 12, 32, 2), dto.getUpdatedAt());
  }
}