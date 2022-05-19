package com.example.inbounds.rest;

import com.example.domain.domain.Product;
import com.example.domain_connectors.ProductMessageService;
import com.example.domain_connectors.mappers.ProductRequestMapper;
import com.example.inbounds.rest.apidoc.products.ProductsCommandApi;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocDelete;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocInsert;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocUpdate;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsCommandApi {

  private final ProductMessageService inPort;
  private final ProductRequestMapper requestMapper = Mappers.getMapper(ProductRequestMapper.class);

  @PostMapping
  public ResponseEntity<SimpleResponseDto<String>> save(final @RequestBody ProductRequestDTO dto) {

    Product vo = requestMapper.mapRequest(dto);
    String msg = inPort.sendCreateMessage(vo);

    return SimpleResponseDto.success(ApiDocInsert.Response.Success.SC, msg);
  }

  @PutMapping
  public ResponseEntity<SimpleResponseDto<String>> update(final @RequestBody ProductRequestDTO dto) {

    Product vo = requestMapper.mapRequest(dto);
    String msg = inPort.sendUpdateMessage(vo);

    return SimpleResponseDto.success(ApiDocUpdate.Response.Success.SC, msg);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SimpleResponseDto<String>> delete(final @PathVariable String id) {

    String msg = inPort.sendDeleteMessage(id);

    return SimpleResponseDto.success(ApiDocDelete.Response.Success.SC, msg);
  }
}
