package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.domain.exceptions.BadRequestException;
import com.example.domain.exceptions.ProductNotFoundException;
import com.example.domain_connectors.ProductMessageService;
import com.example.outbound_connectors.ProductMessageOutPort;
import com.example.outbound_connectors.ProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductMessageServiceImpl implements ProductMessageService {

  private final ProductMessageOutPort outMessagePort;
  private final ProductOutPort outPort;

  @Override
  public String sendCreateMessage(final Product vo) {

    if (vo.getId() != null) {
      throw new BadRequestException("Id found. Try updating instead.");
    }

    return outMessagePort.sendCreateMessage(vo);
  }

  @Override
  public String sendUpdateMessage(final Product vo) {

    if (vo.getId() == null) {
      throw new BadRequestException("Id not found. Try inserting instead.");
    }

    if (!outPort.exists(vo.getId())) {
      throw new ProductNotFoundException("Product with specified id not found.");
    }

    return outMessagePort.sendUpdateMessage(vo);
  }

  @Override
  public String sendDeleteMessage(final String id) {
    return outMessagePort.sendDeleteMessage(id);
  }
}
