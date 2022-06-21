package com.example.inbounds.web;

import com.example.commons.dtos.BrandResponseDTO;
import com.example.commons.uri.BrandsUriResolver;
import com.example.commons.uri.UriResolver;
import com.example.inbounds.web.dtos.BrandFollowResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/ecommerce/brands")
@RequiredArgsConstructor
public class BrandWebController {

    private final WebClient webClient;
    private final UriResolver uriResolver = new BrandsUriResolver();

    @GetMapping
    public String findAll(final Model model) throws URISyntaxException {

        Mono<List<BrandResponseDTO>> response = webClient.get()
                .uri(uriResolver.getRestUri())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        List<BrandResponseDTO> brands = response.block();

        model.addAttribute("brands", brands);

        return "brands";
    }

    @PostMapping(value = "/follow", produces = "application/json")
    @ResponseBody
    public ResponseEntity<BrandFollowResponseDTO> follow(final @RequestParam String brandId) {

        return ResponseEntity.ok(new BrandFollowResponseDTO(true, "Following brand."));
    }
}
