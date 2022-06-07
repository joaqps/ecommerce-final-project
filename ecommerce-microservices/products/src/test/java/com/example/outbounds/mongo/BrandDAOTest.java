package com.example.outbounds.mongo;

import com.example.domain.Brand;
import com.example.outbound_connectors.mappers.BrandEntityMapper;
import com.example.outbounds.mongo.entities.BrandEntity;
import com.example.outbounds.mongo.repositories.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandDAOTest {

	@Mock
	BrandRepository repository;
	@Mock
	BrandEntityMapper mapper;
	@InjectMocks
	BrandDAOImpl brandDAO;

	@Test
	void test_find_all() {

		when(repository.findAll()).thenReturn(List.of(BrandEntity.builder().name("Brand").build()));
		when(mapper.mapEntity(any())).thenReturn(new Brand("1", "Brand", null));

		List<Brand> brands = brandDAO.findAll();

		assertNotNull(brands.get(0));
		assertEquals("Brand", brands.get(0).getName());
	}
}