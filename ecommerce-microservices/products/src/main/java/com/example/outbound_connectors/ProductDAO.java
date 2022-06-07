package com.example.outbound_connectors;

import com.example.domain.Product;

import java.util.List;

public interface ProductDAO {

	Product save(Product entity);

	Product update(Product entity);

	void delete(String id);

	boolean exists(String id);

	List<Product> findAll();
}
