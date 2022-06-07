package com.example.inbounds.rest;

import com.example.domain.Product;
import com.example.domain_connectors.ProductService;
import com.example.domain_connectors.mappers.ProductDTOMapper;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest extends MockMvcTest {

	ProductDTOMapper mapper = Mappers.getMapper(ProductDTOMapper.class);

	@Mock
	ProductService productService;

	@Override
	protected String getUriRoot() {
		return "/products";
	}

	@Override
	protected Object buildController() {
		return new ProductController(productService, mapper);
	}

	@Test
	void test_save() {

		ProductRequestDTO dto = new ProductRequestDTO();
		String payload = dtoToJson(dto);

		when(productService.save(any())).thenReturn(Product.builder().name("Product").build());

		final ResultActions response = performer().post("/", payload);

		buildAsserter(response).statusBodyJson(HttpStatus.CREATED, "{data:{'name':'Product'}}");
	}

	@Test
	void test_update() {

		ProductRequestDTO dto = new ProductRequestDTO();
		String payload = dtoToJson(dto);

		when(productService.update(any())).thenReturn(Product.builder().name("Product").build());

		final ResultActions response = performer().put("/", payload);

		buildAsserter(response).statusBodyJson(HttpStatus.OK, "{data:{'name':'Product'}}");
	}

	@Test
	void test_delete() {

		final ResultActions response = performer().delete("/1");

		buildAsserter(response).status(HttpStatus.OK);
	}

	@Test
	void test_find_all() {

		final ResultActions response = performer().get("/");

		buildAsserter(response).status(HttpStatus.OK);
	}
}