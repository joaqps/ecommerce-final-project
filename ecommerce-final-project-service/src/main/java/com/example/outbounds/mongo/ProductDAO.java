package com.example.outbounds.mongo;

import com.example.outbounds.mongo.entities.ProductEntity;
import com.example.outbound_connectors.mappers.ProductEntityMapper;
import com.example.outbounds.mongo.repository.ProductRepository;
import com.example.domain.domain.Product;
import com.example.outbound_connectors.ProductOutPort;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDAO implements ProductOutPort {

  private final ProductRepository repository;
  private final ProductEntityMapper mapper = Mappers.getMapper(ProductEntityMapper.class);

  @Override
  public Product save(final Product vo) {

    ProductEntity entity = mapper.mapVo(vo);
    ProductEntity savedEntity = repository.save(entity);

    return mapper.mapEntity(savedEntity);
  }

  @Override
  public Product update(final Product vo) {

    ProductEntity entity = mapper.mapVo(vo);
    ProductEntity updatedEntity = repository.save(entity);

    return mapper.mapEntity(updatedEntity);
  }

  @Override
  public void delete(final String id) {

    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }
}
