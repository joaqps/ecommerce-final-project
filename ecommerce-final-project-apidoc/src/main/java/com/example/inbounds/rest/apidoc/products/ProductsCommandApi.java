package com.example.inbounds.rest.apidoc.products;

import com.example.inbounds.rest.apidoc.ProductsApi;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
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

  String PARAM_SAVE = "Product to save";
  String PARAM_UPDATE = "Product to update";
  String PARAM_DELETE = "Id of the product to delete";

  @ProductsApi.ProductCommand
  ResponseEntity<SimpleResponseDto<String>> save(@Parameter(description = PARAM_SAVE) @RequestBody(required = true) ProductRequestDTO dto);

  @ProductsApi.ProductCommand
  ResponseEntity<SimpleResponseDto<String>> update(
      @Parameter(description = PARAM_UPDATE) @RequestBody(required = true) ProductRequestDTO dto);

  @ProductsApi.ProductCommand
  ResponseEntity<SimpleResponseDto<String>> delete(@Parameter(description = PARAM_DELETE) @PathVariable(required = true) String id);
}
