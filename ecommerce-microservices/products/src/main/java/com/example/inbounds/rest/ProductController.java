package com.example.inbounds.rest;

import com.example.domain.Product;
import com.example.domain_connectors.ProductService;
import com.example.domain_connectors.mappers.ProductDTOMapper;
import com.example.inbounds.rest.apidoc.products.ProductsCommandApi;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import com.example.inbounds.rest.dtos.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocDelete;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocInsert;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocUpdate;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsCommandApi {

	private final ProductService productService;
	private final ProductDTOMapper productMapper;

	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> findAll() {

		List<ProductResponseDTO> products = productService.findAll().stream().map(productMapper::mapResponse)
				.collect(Collectors.toList());

		return ResponseEntity.ok(products);
	}

	@PostMapping
	public ResponseEntity<SimpleResponseDto<ProductResponseDTO>> save(final @RequestBody ProductRequestDTO dto) {

		Product vo = productMapper.mapRequest(dto);
		Product savedVo = productService.save(productMapper.mapRequest(dto));

		return SimpleResponseDto.success(ApiDocInsert.Response.Success.SC, productMapper.mapResponse(savedVo));
	}

	@PutMapping
	public ResponseEntity<SimpleResponseDto<ProductResponseDTO>> update(final @RequestBody ProductRequestDTO dto) {

		Product vo = productMapper.mapRequest(dto);
		Product updatedVo = productService.update(productMapper.mapRequest(dto));

		return SimpleResponseDto.success(ApiDocUpdate.Response.Success.SC, productMapper.mapResponse(updatedVo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SimpleResponseDto<Void>> delete(final @PathVariable String id) {

		productService.delete(id);

		return SimpleResponseDto.success(ApiDocDelete.Response.Success.SC);
	}
}
