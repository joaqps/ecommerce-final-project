package com.example.outbounds.mongo;

import com.example.domain.Product;
import com.example.outbound_connectors.ProductDAO;
import com.example.outbound_connectors.mappers.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import com.example.outbounds.mongo.entities.ProductEntity;
import com.example.outbounds.mongo.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

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

	@Override
	public boolean exists(final String id) {
		return repository.existsById(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll().stream().map(mapper::mapEntity).collect(Collectors.toList());
	}
}
