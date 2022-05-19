package com.example.inbounds.kafka;

import com.example.domain_connectors.RateService;
import com.example.inbounds.kafka.dtos.PriceChangeKafkaDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RateKafkaConsumerTest {

  @Mock
  RateService inPort;
  @InjectMocks
  RateKafkaConsumer kafkaConsumer;

  @Test
  void test_price_change() {

    kafkaConsumer.onPriceChange(new ConsumerRecord<>("products", 1, 1, "1", new PriceChangeKafkaDTO()));

    verify(inPort).updateRate(any());
  }
}