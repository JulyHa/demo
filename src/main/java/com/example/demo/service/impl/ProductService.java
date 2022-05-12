package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(Pageable pageable, String name) {
        return productRepository.findAllByNameContaining(pageable, name);
    }


    @Override
    public Iterable<Category> findAllByCategoryId(Long id) {
        return productRepository.findAllByCategoryId(id);
    }
}
