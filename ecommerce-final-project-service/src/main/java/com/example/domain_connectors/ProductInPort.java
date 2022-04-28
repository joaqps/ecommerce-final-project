package com.example.domain_connectors;

import com.example.domain.domain.Product;

public interface ProductInPort {

  void save(Product vo);

  void update(Product vo);

  void delete(String id);
}
