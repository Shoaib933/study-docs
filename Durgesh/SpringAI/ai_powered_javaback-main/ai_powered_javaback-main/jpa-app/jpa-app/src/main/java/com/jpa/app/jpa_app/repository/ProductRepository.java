package com.jpa.app.jpa_app.repository;

import com.jpa.app.jpa_app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
