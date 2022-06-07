package com.example.inbounds.web;

import com.example.commons.uri.BrandsUriResolver;
import com.example.commons.uri.UriResolver;
import com.example.inbounds.rest.dtos.BrandResponseDTO;
import com.example.inbounds.web.dtos.BrandFollowResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/ecommerce/brands")
@RequiredArgsConstructor
public class BrandWebController {

	private final RestTemplate restTemplate;
	private final UriResolver uriResolver = new BrandsUriResolver();

	@GetMapping
	public String findAll(final Model model) {

		ResponseEntity<SimpleResponseDto<List<BrandResponseDTO>>> response = restTemplate
				.exchange(uriResolver.getRestUri(), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
				});

		List<BrandResponseDTO> brands = Objects.requireNonNull(response.getBody()).getData();

		model.addAttribute("brands", brands);

		return "brands";
	}

	@PostMapping(value = "/follow", produces = "application/json")
	@ResponseBody
	public ResponseEntity<BrandFollowResponseDTO> follow(final @RequestParam String brandId) {

		return ResponseEntity.ok(new BrandFollowResponseDTO(true, "Following brand."));
	}
}
