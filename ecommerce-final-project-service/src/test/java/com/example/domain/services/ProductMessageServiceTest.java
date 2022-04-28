package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.domain.exceptions.BadRequestException;
import com.example.domain.exceptions.ProductNotFoundException;
import com.example.outbound_connectors.ProductMessageOutPort;
import com.example.outbound_connectors.ProductOutPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductMessageServiceTest {

  @Mock
  ProductMessageOutPort outMessagePort;
  @Mock
  ProductOutPort outPort;
  @InjectMocks
  ProductMessageService service;

  @Test
  void test_create_id() {

    Product vo = new Product();
    vo.setId("1");

    RuntimeException thrown = assertThrows(BadRequestException.class, () -> service.sendCreateMessage(vo));

    assertEquals("Id found. Try updating instead.", thrown.getMessage());
  }

  @Test
  void test_create() {

    Product vo = new Product();

    String msg = service.sendCreateMessage(vo);

    verify(outMessagePort).sendCreateMessage(any());
  }

  @Test
  void test_update_no_id() {

    Product vo = new Product();

    RuntimeException thrown = assertThrows(BadRequestException.class, () -> service.sendUpdateMessage(vo));

    assertEquals("Id not found. Try inserting instead.", thrown.getMessage());
  }

  @Test
  void test_update_not_found() {

    Product vo = new Product();
    vo.setId("1");

    when(outPort.exists(any())).thenReturn(false);

    RuntimeException thrown = assertThrows(ProductNotFoundException.class, () -> service.sendUpdateMessage(vo));

    assertEquals("Product with specified id not found.", thrown.getMessage());
  }

  @Test
  void test_update() {

    Product vo = new Product();
    vo.setId("1");

    when(outPort.exists(any())).thenReturn(true);

    String msg = service.sendUpdateMessage(vo);

    verify(outMessagePort).sendUpdateMessage(any());
  }

  @Test
  void test_delete() {

    String msg = service.sendDeleteMessage("1");

    verify(outMessagePort).sendDeleteMessage(any());
  }
}