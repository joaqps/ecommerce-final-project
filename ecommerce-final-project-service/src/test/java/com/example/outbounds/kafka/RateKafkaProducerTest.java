package com.example.outbounds.kafka;

import com.example.inbounds.kafka.dtos.PriceChangeKafkaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RateKafkaProducerTest {

  @Mock
  KafkaTemplate<String, PriceChangeKafkaDTO> kafkaTemplate;
  @InjectMocks
  RateKafkaProducer kafkaProducer;

  @Test
  void test_price_change() {

    String msg = kafkaProducer.sendPriceChangeMessage("1", BigDecimal.ZERO);

    verify(kafkaTemplate).send(any(), any());

    assertEquals("Price change sent", msg);
  }
}