package com.example.outbounds.mongo;

import com.example.domain.Rate;
import com.example.domain.exceptions.RateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.example.outbound_connectors.RateDAO;
import com.example.outbound_connectors.mappers.RateEntityMapper;
import com.example.outbounds.mongo.entities.RateEntity;
import com.example.outbounds.mongo.repositories.RateRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RateDAOImpl implements RateDAO {

	private final Logger logger = LoggerFactory.getLogger(RateDAOImpl.class);

	private final RateRepository repository;
	private final RateEntityMapper mapper = Mappers.getMapper(RateEntityMapper.class);

	@Override
	public Optional<Rate> findByProductIdBrandIdAndDate(final String productId, final String brandId,
			final LocalDateTime date) {

		List<RateEntity> list = repository.findAllByProductIdAndBrandIdAndStartDate(productId, brandId, date);

		return list.stream().max(Comparator.comparingInt(RateEntity::getPriority)).map(mapper::mapEntity);
	}

	@Override
	public boolean exists(final String id) {
		return repository.existsById(id);
	}

	@Override
	public Rate updateRate(String rateId, BigDecimal price) {

		Optional<RateEntity> rateEntity = repository.findById(rateId);

		if (rateEntity.isEmpty()) {
			throw new RateNotFoundException("Rate with give id doesn't exist.");
		}

		RateEntity updatedRateEntity = rateEntity.get();
		updatedRateEntity.setPrice(price);

		repository.save(updatedRateEntity);

		return mapper.mapEntity(updatedRateEntity);
	}
}
