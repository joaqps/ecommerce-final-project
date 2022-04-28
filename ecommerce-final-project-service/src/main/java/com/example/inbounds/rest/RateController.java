package com.example.inbounds.rest;

import com.example.domain.domain.Rate;
import com.example.domain_connectors.RateInPort;
import com.example.domain_connectors.mappers.RateResponseMapper;
import com.example.inbounds.rest.apidoc.rates.RatesCommandApi;
import com.example.inbounds.rest.apidoc.rates.RatesQueryApi;
import com.example.inbounds.rest.dtos.PriceChangeRequestDTO;
import com.example.inbounds.rest.dtos.RateQueryDTO;
import com.example.inbounds.rest.dtos.RateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocUpdate;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query.ApiDocFindById;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RateController implements RatesQueryApi, RatesCommandApi {

  private final RateInPort inPort;
  private final RateResponseMapper responseMapper;

  @PostMapping("/find")
  public ResponseEntity<SimpleResponseDto<RateResponseDTO>> findByProductIdBrandIdAndDate(final @RequestBody RateQueryDTO params) {

    Optional<Rate> vo = inPort.findByProductIdBrandIdAndDate(params.getProductId(), params.getBrandId(), params.getDate());

    if (vo.isEmpty()) {
      return SimpleResponseDto.error(ApiDocCommons.Error.NotFound.SC, ApiDocCommons.Error.NotFound.MSG);
    }

    RateResponseDTO responseDTO = responseMapper.mapResponse(vo.get());
    return SimpleResponseDto.success(ApiDocFindById.Response.Success.SC, responseDTO);
  }

  @PutMapping
  public ResponseEntity<SimpleResponseDto<String>> updateRate(final @RequestBody PriceChangeRequestDTO dto) {

    String msg = inPort.sendPriceChangeMessage(dto.getRateId(), dto.getPrice());

    return SimpleResponseDto.success(ApiDocUpdate.Response.Success.SC, msg);
  }
}
