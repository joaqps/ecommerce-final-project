package com.example.outbound_connectors;

import com.example.domain.Rate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface RateDAO {

	Optional<Rate> findByProductIdBrandIdAndDate(String productId, String brandId, LocalDateTime date);

	boolean exists(String id);

	Rate updateRate(String rateId, BigDecimal price);
}
