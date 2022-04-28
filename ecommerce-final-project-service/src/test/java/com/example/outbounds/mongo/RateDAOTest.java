package com.example.outbounds.mongo;

import com.example.domain.domain.Rate;
import com.example.outbounds.mongo.entities.RateEntity;
import com.example.outbounds.mongo.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RateDAOTest {

  @Mock
  RateRepository repository;
  @InjectMocks
  RateDAO dao;

  @Test
  void test_find() {

    List<RateEntity> rates = List.of(RateEntity.builder().id(("1")).priority(1).build(),
        RateEntity.builder().id(("2")).priority(3).build());

    when(repository.findAllByProductIdAndBrandIdAndStartDate(any(), any(), any())).thenReturn(rates);

    Optional<Rate> rate = dao.findByProductIdBrandIdAndDate("1", "1", LocalDateTime.now());

    assertTrue(rate.isPresent());
    assertEquals("2", rate.get().getId());
  }

  @Test
  void test_update_() {

    when(repository.findById(any())).thenReturn(Optional.of(new RateEntity()));

    dao.updateRate(new Rate());

    verify(repository).save(any());
  }

  @Test
  void test_update_not_found() {

    when(repository.findById(any())).thenReturn(Optional.empty());

    dao.updateRate(new Rate());

    verify(repository, never()).save(any());
  }
}