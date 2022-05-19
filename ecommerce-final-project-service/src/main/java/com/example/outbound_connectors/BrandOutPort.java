package com.example.outbound_connectors;

import com.example.domain.domain.Brand;

import java.util.List;

public interface BrandOutPort {

  List<Brand> findAll();
}
