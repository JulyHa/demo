package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;

public interface IProductService extends IService<Product> {
    Iterable<Category> findAllByCategoryId(Long id);
}
