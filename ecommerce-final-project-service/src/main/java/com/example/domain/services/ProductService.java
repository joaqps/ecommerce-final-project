package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.domain_connectors.ProductInPort;
import com.example.outbound_connectors.ProductOutPort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service("productService")
public class ProductService implements ProductInPort {

  private final Logger logger = LoggerFactory.getLogger(ProductService.class);

  private final ProductOutPort outPort;

  @Override
  public void save(final Product vo) {

    vo.setCreatedAt(LocalDateTime.now());
    Product savedVo = outPort.save(vo);

    logger.info("Product created: {}", savedVo);
  }

  @Override
  public void update(final Product vo) {

    vo.setUpdatedAt(LocalDateTime.now());
    Product updatedVo = outPort.update(vo);

    logger.info("Product updated: {}", updatedVo);
  }

  @Override
  public void delete(final String id) {
    outPort.delete(id);
  }
}
