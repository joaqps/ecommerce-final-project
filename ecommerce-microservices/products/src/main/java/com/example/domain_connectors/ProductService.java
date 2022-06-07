package com.example.domain_connectors;

import com.example.domain.Product;

import java.util.List;

public interface ProductService {

	Product save(Product vo);

	Product update(Product vo);

	void delete(String id);

	List<Product> findAll();
}
