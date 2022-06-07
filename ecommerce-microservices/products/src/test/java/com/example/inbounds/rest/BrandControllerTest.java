package com.example.inbounds.rest;

import com.example.domain_connectors.BrandService;
import com.example.domain_connectors.mappers.BrandDTOMapper;
import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;

@ExtendWith(MockitoExtension.class)
class BrandControllerTest extends MockMvcTest {

	BrandDTOMapper mapper = Mappers.getMapper(BrandDTOMapper.class);
	@Mock
	BrandService brandService;

	@Override
	protected String getUriRoot() {
		return "/brands";
	}

	@Override
	protected Object buildController() {
		return new BrandController(brandService, mapper);
	}

	@Test
	void test_find_all() {

		final ResultActions response = performer().get("/");

		buildAsserter(response).status(HttpStatus.OK);
	}
}