package com.example.domain.services;

import com.example.outbound_connectors.RateDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RateServiceTest {

	@Mock
	RateDAO outPort;
	@InjectMocks
	RateServiceImpl service;

	@Test
	void test_find() {

		service.findByProductIdBrandIdAndDate("1", "1", LocalDateTime.now());

		verify(outPort).findByProductIdBrandIdAndDate(any(), any(), any());
	}

	@Test
	void test_price_change() {

		service.updateRate("1", BigDecimal.ONE);

		verify(outPort).updateRate(any(), any());
	}

	@Test
	void test_update() {

		service.updateRate("1", BigDecimal.ONE);

		verify(outPort).updateRate(any(), any());
	}
}