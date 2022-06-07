package com.example.inbounds.web;

import com.example.commons.uri.ProductsUriResolver;
import com.example.commons.uri.UriResolver;
import com.example.inbounds.rest.dtos.ProductResponseDTO;
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
@RequestMapping("/ecommerce/products")
@RequiredArgsConstructor
public class ProductWebController {

	private final RestTemplate restTemplate;
	private final UriResolver uriResolver = new ProductsUriResolver();

	@GetMapping
	public String findAll(final Model model) {

		ResponseEntity<SimpleResponseDto<List<ProductResponseDTO>>> response = restTemplate
				.exchange(uriResolver.getRestUri(), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
				});

		List<ProductResponseDTO> products = Objects.requireNonNull(response.getBody()).getData();

		model.addAttribute("products", products);

		return "products";
	}

	@PostMapping(value = "/export", produces = "application/json")
	@ResponseBody
	public String exportAll(final @RequestParam String email) {

		return "{\"response\": \"OK\"}";
	}
}
