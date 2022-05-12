package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.Optional;

public interface ICategoryService extends IService<Category> {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);
}
