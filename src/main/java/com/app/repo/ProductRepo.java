package com.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.product.Product;

@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer> {
   
}

