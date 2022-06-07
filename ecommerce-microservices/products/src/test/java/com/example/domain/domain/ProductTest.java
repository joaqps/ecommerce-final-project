package com.example.domain.domain;

import com.example.domain.Product;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

	@Test
	void test_fields() {

		Product product = new Product();
		product.setId("1");
		product.setName("Apple");
		product.setCategory("Fruit");
		product.setEndOfSaleDate(LocalDateTime.of(2022, 4, 27, 10, 30, 0));
		product.setCreatedAt(LocalDateTime.of(2020, 1, 1, 10, 0, 0));
		product.setUpdatedAt(LocalDateTime.of(2021, 2, 2, 11, 11, 11));

		assertEquals("1", product.getId());
		assertEquals("Apple", product.getName());
		assertEquals("Fruit", product.getCategory());
		assertEquals(LocalDateTime.of(2022, 4, 27, 10, 30, 0), product.getEndOfSaleDate());
		assertEquals(LocalDateTime.of(2020, 1, 1, 10, 0, 0), product.getCreatedAt());
		assertEquals(LocalDateTime.of(2021, 2, 2, 11, 11, 11), product.getUpdatedAt());
	}

}