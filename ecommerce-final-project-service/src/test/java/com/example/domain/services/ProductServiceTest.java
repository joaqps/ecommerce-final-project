package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.outbound_connectors.ProductOutPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock
  ProductOutPort outPort;
  @InjectMocks
  ProductService service;
  @Captor
  ArgumentCaptor<Product> captor;

  @Test
  void test_save() {

    Product vo = new Product();

    service.save(vo);

    verify(outPort).save(captor.capture());

    Product capturedVo = captor.getValue();
    assertNull(capturedVo.getUpdatedAt());
    assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), capturedVo.getCreatedAt().truncatedTo(ChronoUnit.MINUTES));
  }

  @Test
  void test_update() {

    Product vo = new Product();

    service.update(vo);

    verify(outPort).update(captor.capture());

    Product capturedVo = captor.getValue();
    assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), capturedVo.getUpdatedAt().truncatedTo(ChronoUnit.MINUTES));
  }

  @Test
  void test_delete() {

    service.delete("1");

    verify(outPort).delete(any());
  }
}