package com.example.domain.services;

import com.example.outbound_connectors.BrandDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

	@Mock
	BrandDAO brandDAO;
	@InjectMocks
	BrandServiceImpl brandService;

	@Test
	void test_find_all() {

		brandService.findAll();

		verify(brandDAO).findAll();
	}
}