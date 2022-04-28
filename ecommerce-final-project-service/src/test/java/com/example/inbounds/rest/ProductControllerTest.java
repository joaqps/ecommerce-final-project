package com.example.inbounds.rest;

import com.example.domain_connectors.ProductMessageInPort;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest extends MockMvcTest {

  @Mock
  ProductMessageInPort inPort;

  @Override
  protected String getUriRoot() {
    return "/products";
  }

  @Override
  protected Object buildController() {
    return new ProductController(inPort);
  }

  @Test
  void test_save() {

    ProductRequestDTO dto = new ProductRequestDTO();
    String payload = dtoToJson(dto);

    when(inPort.sendCreateMessage(any())).thenReturn("Message sent");

    final ResultActions response = performer().post("/", payload);

    buildAsserter(response).statusBodyJson(HttpStatus.CREATED, "{data:'Message sent'}");
  }

  @Test
  void test_update() {

    ProductRequestDTO dto = new ProductRequestDTO();
    String payload = dtoToJson(dto);

    when(inPort.sendUpdateMessage(any())).thenReturn("Message sent");

    final ResultActions response = performer().put("/", payload);

    buildAsserter(response).statusBodyJson(HttpStatus.OK, "{data:'Message sent'}");
  }

  @Test
  void test_delete() {

    when(inPort.sendDeleteMessage(any())).thenReturn("Message sent");

    final ResultActions response = performer().delete("/1");

    buildAsserter(response).statusBodyJson(HttpStatus.OK, "{data:'Message sent'}");
  }
}