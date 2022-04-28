package com.example.outbounds.kafka;

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

@ExtendWith(MockitoExtension.class)
class ProductKafkaProducerStrTest {

  @Mock
  KafkaTemplate<String, String> kafkaTemplateStr;
  @Mock
  ProductKafkaProducerMapper mapper;
  @InjectMocks
  ProductKafkaProducer kafkaProducer;

  @Test
  void test_delete() {

    String msg = kafkaProducer.sendDeleteMessage("1");

    verify(kafkaTemplateStr).send(any(), any()); // Mock is mapping the wrong bean

    assertEquals("Product delete message sent", msg);
  }
}