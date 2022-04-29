package com.example.outbounds.mongo;

import com.example.outbounds.mongo.entities.RateEntity;
import com.example.outbound_connectors.mappers.RateEntityMapper;
import com.example.outbounds.mongo.repository.RateRepository;
import com.example.domain.domain.Rate;
import com.example.outbound_connectors.RateOutPort;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RateDAO implements RateOutPort {

  private final Logger logger = LoggerFactory.getLogger(RateDAO.class);

  private final RateRepository repository;
  private final RateEntityMapper mapper = Mappers.getMapper(RateEntityMapper.class);

  @Override
  public Optional<Rate> findByProductIdBrandIdAndDate(final String productId, final String brandId, final LocalDateTime date) {

    List<RateEntity> list = repository.findAllByProductIdAndBrandIdAndStartDate(productId, brandId, date);

    return list.stream().max(Comparator.comparingInt(RateEntity::getPriority)).map(mapper::mapEntity);
  }

  @Override public boolean exists(String id) {
    return repository.existsById(id);
  }

  @Override
  public void updateRate(final Rate rate) {

    Optional<RateEntity> rateEntity = repository.findById(rate.getId());

    if (rateEntity.isPresent()) {

      RateEntity updatedRateEntity = rateEntity.get();
      updatedRateEntity.setPrice(rate.getPrice());

      repository.save(updatedRateEntity);
      logger.info("Updated rate: {}", updatedRateEntity);
    } else {
      logger.error("Rate with id [{}] not found", rate.getId());
    }
  }
}
