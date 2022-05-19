package com.example.outbounds.mongo;

import com.example.domain.domain.Brand;
import com.example.outbound_connectors.BrandOutPort;
import com.example.outbound_connectors.mappers.BrandEntityMapper;
import com.example.outbounds.mongo.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BrandDAO implements BrandOutPort {

  private final BrandRepository repository;
  private final BrandEntityMapper mapper = Mappers.getMapper(BrandEntityMapper.class);

  @Override
  public List<Brand> findAll() {
    return repository.findAll().stream().map(mapper::mapEntity).collect(Collectors.toList());
  }
}
