package com.example.inbounds.rest.apidoc.brands;

import com.example.inbounds.rest.apidoc.BrandsApi;
import com.example.inbounds.rest.dtos.BrandResponseDTO;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = BrandsApi.MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@BrandsApi.BrandQuery
public interface BrandsQueryApi {

	@BrandsApi.BrandQuery
	ResponseEntity<List<BrandResponseDTO>> findAll();
}
