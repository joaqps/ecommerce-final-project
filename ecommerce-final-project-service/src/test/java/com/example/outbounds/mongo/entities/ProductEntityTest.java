package com.example.outbounds.mongo.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityTest {

  @Test
  void test_fields() {

    ProductEntity productEntity = new ProductEntity();
    productEntity.setId("1");
    productEntity.setName("Apple");
    productEntity.setCategory("Fruit");
    productEntity.setEndOfSaleDate(LocalDateTime.of(2022, 4, 27, 10, 30, 0));
    productEntity.setCreatedAt(LocalDateTime.of(2020, 1, 1, 10, 0, 0));
    productEntity.setUpdatedAt(LocalDateTime.of(2021, 2, 2, 11, 11, 11));

    assertEquals("1", productEntity.getId());
    assertEquals("Apple", productEntity.getName());
    assertEquals("Fruit", productEntity.getCategory());
    assertEquals(LocalDateTime.of(2022, 4, 27, 10, 30, 0), productEntity.getEndOfSaleDate());
    assertEquals(LocalDateTime.of(2020, 1, 1, 10, 0, 0), productEntity.getCreatedAt());
    assertEquals(LocalDateTime.of(2021, 2, 2, 11, 11, 11), productEntity.getUpdatedAt());
  }
}