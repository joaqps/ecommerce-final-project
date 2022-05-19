package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.domain.domain.User;
import com.example.domain_connectors.ProductService;
import com.example.outbound_connectors.ProductNotificationOutPort;
import com.example.outbound_connectors.ProductOutPort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service("productService")
public class ProductServiceImpl implements ProductService {

  private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

  private final ProductOutPort outPort;
  private final ProductNotificationOutPort notificationOutPort;

  @Override
  public void saveAndNotify(final Product vo) {

    vo.setCreatedAt(LocalDateTime.now());
    Product savedVo = outPort.save(vo);

    List<User> subscribedUsers = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      subscribedUsers.add(new User("1", "john", "afe@gmail.es"));
    }

    notificationOutPort.notifyNewProduct(subscribedUsers, savedVo);

    logger.info("Product created: {}", savedVo);
    logger.info("{} users were notified.", subscribedUsers.size());
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

  @Override
  public List<Product> findAll() {
    return outPort.findAll();
  }
}
