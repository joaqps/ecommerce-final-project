package com.example.domain.services;

import com.example.domain.domain.Brand;
import com.example.domain_connectors.BrandService;
import com.example.outbound_connectors.BrandOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

  private final BrandOutPort outPort;

  @Override
  public List<Brand> findAll() {
    return outPort.findAll();
  }
}
