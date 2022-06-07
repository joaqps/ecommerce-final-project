package com.example.domain.services;

import com.example.domain.Brand;
import com.example.domain_connectors.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.outbound_connectors.BrandDAO;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

	private final BrandDAO brandDAO;

	@Override
	public List<Brand> findAll() {
		return brandDAO.findAll();
	}
}
