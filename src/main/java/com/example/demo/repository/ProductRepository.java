package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByNameContaining(Pageable pageable, String name);

    Iterable<Category> findAllByCategoryId(Long id);
}
