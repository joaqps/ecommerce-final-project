package com.example.domain.services;

import com.example.domain.domain.Rate;
import com.example.domain.exceptions.RateNotFoundException;
import com.example.domain_connectors.RateInPort;
import com.example.outbound_connectors.RateOutPort;
import com.example.outbounds.kafka.RateKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RateService implements RateInPort {

  private final RateOutPort outPort;
  private final RateKafkaProducer kafkaProducer;

  @Override
  public Optional<Rate> findByProductIdBrandIdAndDate(final String productId, final String brandId, final LocalDateTime date) {
    return outPort.findByProductIdBrandIdAndDate(productId, brandId, date);
  }

  @Override
  public String sendPriceChangeMessage(final String rateId, final BigDecimal price) {

    if (!outPort.exists(rateId)) {
        throw new RateNotFoundException("Rate with specified id not found.");
    }

    return kafkaProducer.sendPriceChangeMessage(rateId, price);
  }

  @Override
  public void updateRate(final Rate rate) {
    outPort.updateRate(rate);
  }
}
