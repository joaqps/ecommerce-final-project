package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRequestDTOTest {

  @Test
  void test_fields() {

    ProductRequestDTO dto = new ProductRequestDTO();
    dto.setId("1");
    dto.setName("Apple");
    dto.setCategory("Fruit");
    dto.setEndOfSaleDate(LocalDateTime.of(2022, 1, 1, 10, 0, 0));

    assertEquals("1", dto.getId());
    assertEquals("Apple", dto.getName());
    assertEquals("Fruit", dto.getCategory());
    assertEquals(LocalDateTime.of(2022, 1, 1, 10, 0, 0), dto.getEndOfSaleDate());
//    RestDtoTester.test(dto, ProductRequestDTO.JSON_TYPE_REF);
  }
}