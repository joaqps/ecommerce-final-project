package com.example.inbounds.rest.apidoc.products;

import com.example.inbounds.rest.apidoc.ProductsApi;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import com.example.inbounds.rest.dtos.ProductResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = ProductsApi.MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@ProductsApi.ProductCommand
public interface ProductsCommandApi {

	@ProductsApi.ProductCommand
	ResponseEntity<SimpleResponseDto<ProductResponseDTO>> save(
			@Parameter @RequestBody ProductRequestDTO dto);

	@ProductsApi.ProductCommand
	ResponseEntity<SimpleResponseDto<ProductResponseDTO>> update(
			@Parameter @RequestBody ProductRequestDTO dto);

	@ProductsApi.ProductCommand
	ResponseEntity<SimpleResponseDto<Void>> delete(@Parameter @PathVariable String id);
}
