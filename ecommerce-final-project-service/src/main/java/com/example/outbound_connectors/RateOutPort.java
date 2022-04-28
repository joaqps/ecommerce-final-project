package com.example.outbound_connectors;

import com.example.domain.domain.Rate;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RateOutPort {

  Optional<Rate> findByProductIdBrandIdAndDate(String productId, String brandId, LocalDateTime date);

  void updateRate(Rate rate);
}
