package com.example.inbounds.kafka;

import com.example.domain.domain.Rate;
import com.example.domain_connectors.RateInPort;
import com.example.inbounds.kafka.dtos.PriceChangeKafkaDTO;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateKafkaConsumer {

  private final RateInPort inPort;

  @KafkaListener(topics = "prices")
  public void onPriceChange(final ConsumerRecord<String, PriceChangeKafkaDTO> message) {

    PriceChangeKafkaDTO kafkaDTO = message.value();

    Rate rate = Rate.builder().id(kafkaDTO.getRateId()).price(kafkaDTO.getPrice()).build();

    inPort.updateRate(rate);
  }
}
