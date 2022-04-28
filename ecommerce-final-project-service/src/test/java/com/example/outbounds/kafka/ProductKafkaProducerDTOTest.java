package com.example.outbounds.kafka;

import com.example.domain.domain.Product;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import com.example.outbound_connectors.mappers.ProductKafkaProducerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductKafkaProducerDTOTest {

  @Mock
  KafkaTemplate<String, ProductKafkaDTO> kafkaTemplateDTO;
  @Mock
  ProductKafkaProducerMapper mapper;
  @InjectMocks
  ProductKafkaProducer kafkaProducer;

  @Test
  void test_create() {

    Product vo = new Product();

    when(mapper.of(any())).thenReturn(new ProductKafkaDTO());

    String msg = kafkaProducer.sendCreateMessage(vo);

    verify(kafkaTemplateDTO).send(any(), any());
    verify(mapper).of(any());

    assertEquals("Product create message sent", msg);
  }

  @Test
  void test_update() {

    Product vo = new Product();

    when(mapper.of(any())).thenReturn(new ProductKafkaDTO());

    String msg = kafkaProducer.sendUpdateMessage(vo);

    verify(kafkaTemplateDTO).send(any(), any());
    verify(mapper).of(any());

    assertEquals("Product update message sent", msg);
  }
}