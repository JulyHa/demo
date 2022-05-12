package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.model.Product;
import com.example.demo.model.Student;
import com.example.demo.service.IProductService;
import com.example.demo.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),
                    new File("/Users/daonhuanh/Desktop/Codegym/Module1/demoAjax/image/" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Image image = new Image(fileName, fileName);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    //bug
    @GetMapping("/category")
    public ResponseEntity findByCategoryId(@RequestParam Long id) {
        return new ResponseEntity(productService.findAllByCategoryId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/filter")
//    public ResponseEntity<Page<Product>> findByName(@PathVariable String name) {
//        return new ResponseEntity<>(productService.findAllByNameContaining(name).get(), HttpStatus.OK);
//    }
}
