package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.outbound_connectors.ProductMessageOutPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductMessageServiceTest {

  @Mock
  ProductMessageOutPort outPort;
  @InjectMocks
  ProductMessageService service;

  @Test
  void test_create_id() {

    Product vo = new Product();
    vo.setId("1");

    String msg = service.sendCreateMessage(vo);

    assertEquals("Id found. Try updating instead.", msg);
  }

  @Test
  void test_create() {

    Product vo = new Product();

    String msg = service.sendCreateMessage(vo);

    verify(outPort).sendCreateMessage(any());
  }

  @Test
  void test_update_no_id() {

    Product vo = new Product();

    String msg = service.sendUpdateMessage(vo);

    assertEquals("Id not found. Try inserting instead.", msg);
  }

  @Test
  void test_update() {

    Product vo = new Product();
    vo.setId("1");

    String msg = service.sendUpdateMessage(vo);

    verify(outPort).sendUpdateMessage(any());
  }

  @Test
  void test_delete() {

    String msg = service.sendDeleteMessage("1");
  }
}