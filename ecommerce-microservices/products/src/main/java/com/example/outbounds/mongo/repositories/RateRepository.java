package com.example.outbounds.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.outbounds.mongo.entities.RateEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RateRepository extends MongoRepository<RateEntity, String> {

	@Query("{ 'productId' : ?0, 'brandId' : ?1, 'startDate' : { $lt: ?2 }, 'endDate' : { $gt: ?2 } }")
	List<RateEntity> findAllByProductIdAndBrandIdAndStartDate(String productId, String brandId, LocalDateTime date);
}
