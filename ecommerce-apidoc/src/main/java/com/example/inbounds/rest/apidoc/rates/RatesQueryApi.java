package com.example.inbounds.rest.apidoc.rates;

import com.example.inbounds.rest.apidoc.RatesApi;
import com.example.inbounds.rest.dtos.RateQueryDTO;
import com.example.inbounds.rest.dtos.RateResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = RatesApi.MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@RatesApi.RateQuery
public interface RatesQueryApi {

	@RatesApi.RateQuery
	ResponseEntity<SimpleResponseDto<RateResponseDTO>> findByProductIdBrandIdAndDate(
			@Parameter @RequestBody RateQueryDTO params);
}
