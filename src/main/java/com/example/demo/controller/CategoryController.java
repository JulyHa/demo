package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.impl.CategoryService;
import com.example.demo.service.impl.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> edit(@RequestBody Category category, @PathVariable Long id) {
        category.setId(id);
        categoryService.save(category);
        return new ResponseEntity<>(categoryService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
