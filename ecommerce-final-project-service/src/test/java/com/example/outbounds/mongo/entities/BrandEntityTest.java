package com.example.outbounds.mongo.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandEntityTest {

  @Test
  void test_fields() {

    BrandEntity brandEntity = new BrandEntity();
    brandEntity.setId("1");
    brandEntity.setName("ZARA");

    assertEquals("1", brandEntity.getId());
    assertEquals("ZARA", brandEntity.getName());
  }

}