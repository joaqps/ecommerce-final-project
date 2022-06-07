package com.example.outbound_connectors;

import com.example.domain.Brand;

import java.util.List;

public interface BrandDAO {

	List<Brand> findAll();
}
