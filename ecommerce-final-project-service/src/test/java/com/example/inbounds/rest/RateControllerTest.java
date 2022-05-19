package com.example.inbounds.rest;

import com.example.domain.domain.Rate;
import com.example.domain_connectors.RateService;
import com.example.domain_connectors.mappers.RateResponseMapper;
import com.example.inbounds.rest.dtos.PriceChangeRequestDTO;
import com.example.inbounds.rest.dtos.RateQueryDTO;
import com.example.inbounds.rest.dtos.RateResponseDTO;
import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateControllerTest extends MockMvcTest {

  @Mock
  RateService inPort;
  @Mock
  RateResponseMapper responseMapper;

  @Override
  protected String getUriRoot() {
    return "/rates";
  }

  @Override
  protected Object buildController() {
    return new RateController(inPort, responseMapper);
  }

  @Test
  void test_not_find() {

    RateQueryDTO dto = new RateQueryDTO();
    String payload = dtoToJson(dto);

    when(inPort.findByProductIdBrandIdAndDate(any(), any(), any())).thenReturn(Optional.empty());

    final ResultActions response = performer().post("/find", payload);

    buildAsserter(response).status(HttpStatus.NOT_FOUND);
  }

  @Test
  void test_find() {

    RateQueryDTO dto = new RateQueryDTO();
    String payload = dtoToJson(dto);

    when(inPort.findByProductIdBrandIdAndDate(any(), any(), any())).thenReturn(Optional.of(new Rate()));
    when(responseMapper.mapResponse(any())).thenReturn(new RateResponseDTO());

    final ResultActions response = performer().post("/find", payload);

    buildAsserter(response).statusBodyJson(HttpStatus.OK, "{data:{'rateId':null}}");
  }

  @Test
  void test_update() {

    PriceChangeRequestDTO dto = new PriceChangeRequestDTO();
    String payload = dtoToJson(dto);

    when(inPort.sendPriceChangeMessage(any(), any())).thenReturn("");

    final ResultActions response = performer().put("/", payload);

    buildAsserter(response).status(HttpStatus.OK);
  }
}