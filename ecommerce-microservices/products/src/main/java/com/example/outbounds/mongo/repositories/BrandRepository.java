package com.example.outbounds.mongo.repositories;

import com.example.outbounds.mongo.entities.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<BrandEntity, String> {
}
