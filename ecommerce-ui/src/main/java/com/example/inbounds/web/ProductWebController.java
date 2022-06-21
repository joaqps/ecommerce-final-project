package com.example.inbounds.web;

import com.example.commons.dtos.ProductResponseDTO;
import com.example.commons.uri.ProductsUriResolver;
import com.example.commons.uri.UriResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RequestMapping("/ecommerce/products")
@RequiredArgsConstructor
public class ProductWebController {

	private final WebClient webClient;
	private final UriResolver uriResolver = new ProductsUriResolver();

	@GetMapping
	public String findAll(final Model model) {

		Mono<List<ProductResponseDTO>> response = webClient.get()
				.uri(uriResolver.getRestUri())
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<>() {
				});

		List<ProductResponseDTO> products = response.block();

		model.addAttribute("products", products);

		return "products";
	}

	@PostMapping(value = "/export", produces = "application/json")
	@ResponseBody
	public String exportAll(final @RequestParam String email) {

		return "{\"response\": \"OK\"}";
	}
}
