package com.example.outbounds.kafka;

import com.example.inbounds.kafka.dtos.PriceChangeKafkaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class RateKafkaProducer {

  private final KafkaTemplate<String, PriceChangeKafkaDTO> kafkaTemplate;

  public String sendPriceChangeMessage(final String rateId, final BigDecimal price) {

    PriceChangeKafkaDTO dto = new PriceChangeKafkaDTO(rateId, price);
    kafkaTemplate.send("prices", dto);

    return "Price change sent";
  }
}
