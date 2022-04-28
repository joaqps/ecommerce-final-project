package com.example.outbound_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.outbounds.mongo.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductEntityMapperTest {

  ProductEntityMapper mapper = Mappers.getMapper(ProductEntityMapper.class);

  @Test
  void test_mapper_vo_to_entity() {

    Product vo = new Product("1", "name", "category", LocalDateTime.of(2022, 4, 26, 10, 30, 0), LocalDateTime.of(2021, 5, 27, 11, 31, 1),
        LocalDateTime.of(2020, 6, 28, 12, 32, 2));

    ProductEntity entity = mapper.mapVo(vo);

    assertEquals("1", entity.getId());
    assertEquals("name", entity.getName());
    assertEquals("category", entity.getCategory());
    assertEquals(LocalDateTime.of(2022, 4, 26, 10, 30, 0), entity.getEndOfSaleDate());
    assertEquals(LocalDateTime.of(2021, 5, 27, 11, 31, 1), entity.getCreatedAt());
    assertEquals(LocalDateTime.of(2020, 6, 28, 12, 32, 2), entity.getUpdatedAt());
  }

  @Test
  void test_mapper_entity_to_vo() {

    ProductEntity entity = new ProductEntity("1", "name", "category", LocalDateTime.of(2022, 4, 26, 10, 30, 0),
        LocalDateTime.of(2021, 5, 27, 11, 31, 1), LocalDateTime.of(2020, 6, 28, 12, 32, 2));

    Product vo = mapper.mapEntity(entity);

    assertEquals("1", vo.getId());
    assertEquals("name", vo.getName());
    assertEquals("category", vo.getCategory());
    assertEquals(LocalDateTime.of(2022, 4, 26, 10, 30, 0), vo.getEndOfSaleDate());
    assertEquals(LocalDateTime.of(2021, 5, 27, 11, 31, 1), vo.getCreatedAt());
    assertEquals(LocalDateTime.of(2020, 6, 28, 12, 32, 2), vo.getUpdatedAt());
  }
}