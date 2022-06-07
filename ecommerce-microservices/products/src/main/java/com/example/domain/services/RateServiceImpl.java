package com.example.domain.services;

import com.example.domain.Rate;
import com.example.domain_connectors.RateService;
import com.example.outbound_connectors.RateDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

	private final RateDAO rateDAO;

	@Override
	public Optional<Rate> findByProductIdBrandIdAndDate(final String productId, final String brandId,
			final LocalDateTime date) {
		return rateDAO.findByProductIdBrandIdAndDate(productId, brandId, date);
	}

	@Override
	public Rate updateRate(String rateId, BigDecimal price) {

		return rateDAO.updateRate(rateId, price);
	}
}
