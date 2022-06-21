//package com.example.inbounds.web;
//
//import com.example.commons.uri.BrandsUriResolver;
//import com.example.commons.uri.UriResolver;
//import com.example.inbounds.rest.dtos.BrandResponseDTO;
//import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query.ApiDocList;
//import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
//import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class BrandWebControllerTest extends MockMvcTest {
//
//	UriResolver uriResolver = new BrandsUriResolver();
//
//	@Mock
//	RestTemplate  restTemplate;
//
//	@Override
//	protected String getUriRoot() {
//		return "/ecommerce/brands";
//	}
//
//	@Override
//	protected Object buildController() {
//		return new BrandWebController(restTemplate);
//	}
//
//	@Test
//	void test_find_all() {
//
//		when(restTemplate.exchange(uriResolver.getRestUri(), HttpMethod.GET, null,
//				new ParameterizedTypeReference<SimpleResponseDto<List<BrandResponseDTO>>>() {
//				})).thenReturn(SimpleResponseDto.success(ApiDocList.Response.Success.SC,
//						List.of(new BrandResponseDTO("Brand"))));
//
//		final ResultActions response = performer().get("/");
//
//		buildAsserter(response).status(HttpStatus.OK);
//	}
//}