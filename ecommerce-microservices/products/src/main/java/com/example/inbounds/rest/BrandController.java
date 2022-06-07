package com.example.inbounds.rest;

import com.example.domain_connectors.BrandService;
import com.example.domain_connectors.mappers.BrandDTOMapper;
import com.example.inbounds.rest.apidoc.brands.BrandsQueryApi;
import com.example.inbounds.rest.dtos.BrandResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query.ApiDocList;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BrandController implements BrandsQueryApi {

	private final BrandService brandService;
	private final BrandDTOMapper brandMapper;

	@GetMapping
	public ResponseEntity<SimpleResponseDto<List<BrandResponseDTO>>> findAll() {

		List<BrandResponseDTO> brands = brandService.findAll().stream().map(brandMapper::mapResponse)
				.collect(Collectors.toList());

		return SimpleResponseDto.success(ApiDocList.Response.Success.SC, brands);
	}
}
