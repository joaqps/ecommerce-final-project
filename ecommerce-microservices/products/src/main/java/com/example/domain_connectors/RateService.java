package com.example.domain_connectors;

import com.example.domain.Rate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface RateService {

	Optional<Rate> findByProductIdBrandIdAndDate(String productId, String brandId, LocalDateTime date);

	Rate updateRate(String rateId, BigDecimal price);
}
