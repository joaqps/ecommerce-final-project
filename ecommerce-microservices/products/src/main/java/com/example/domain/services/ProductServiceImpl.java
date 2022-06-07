package com.example.domain.services;

import com.example.domain.Product;
import com.example.domain_connectors.ProductService;
import com.example.outbound_connectors.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service("productService")
public class ProductServiceImpl implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ProductDAO outPort;

	@Override
	public Product save(final Product vo) {

		vo.setCreatedAt(LocalDateTime.now());
		return outPort.save(vo);

		// List<User> subscribedUsers = new ArrayList<>();
		// for (int i = 0; i < 50; i++) {
		// subscribedUsers.add(new User("1", "john", "afe@gmail.es"));
		// }
		//
		// notificationOutPort.notifyNewProduct(subscribedUsers, savedVo);
		//
		// logger.info("Product created: {}", savedVo);
		// logger.info("{} users were notified.", subscribedUsers.size());
	}

	@Override
	public Product update(final Product vo) {

		vo.setUpdatedAt(LocalDateTime.now());
		return outPort.update(vo);
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
