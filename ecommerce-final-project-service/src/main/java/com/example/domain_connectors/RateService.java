package com.example.domain_connectors;

import com.example.domain.domain.Rate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface RateService {

  Optional<Rate> findByProductIdBrandIdAndDate(String productId, String brandId, LocalDateTime date);

  String sendPriceChangeMessage(String rateId, BigDecimal price);

  void updateRate(Rate rate);
}
