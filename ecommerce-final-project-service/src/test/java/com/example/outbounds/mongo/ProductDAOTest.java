package com.example.outbounds.mongo;

import com.example.domain.domain.Product;
import com.example.outbounds.mongo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductDAOTest {

  @Mock
  ProductRepository repository;
  @InjectMocks
  ProductDAO dao;

  @Test
  void test_save() {

    Product vo = new Product();

    dao.save(vo);

    verify(repository).save(any());
  }

  @Test
  void test_update() {

    Product vo = new Product();

    dao.update(vo);

    verify(repository).save(any());
  }

  @Test
  void test_delete_not_found() {

    when(repository.existsById(any())).thenReturn(false);

    dao.delete("1");

    verify(repository).existsById(any());
    verify(repository, never()).deleteById(any());
  }

  @Test
  void test_delete() {

    when(repository.existsById(any())).thenReturn(true);

    dao.delete("1");

    verify(repository).existsById(any());
    verify(repository).deleteById(any());
  }

  @Test
  void test_exists() {

    dao.exists("1");

    verify(repository).existsById(any());
  }
}