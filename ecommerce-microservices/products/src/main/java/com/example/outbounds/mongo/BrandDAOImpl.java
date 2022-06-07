package com.example.outbounds.mongo;

import com.example.domain.Brand;
import com.example.outbound_connectors.BrandDAO;
import com.example.outbound_connectors.mappers.BrandEntityMapper;
import com.example.outbounds.mongo.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BrandDAOImpl implements BrandDAO {

	private final BrandRepository repository;
	private final BrandEntityMapper mapper;

	@Override
	public List<Brand> findAll() {
		return repository.findAll().stream().map(mapper::mapEntity).collect(Collectors.toList());
	}
}
