package com.example.demo.service.impl;


import com.example.demo.model.Clazz;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    private ClazzRepository clazzRepository;


    @Override
    public Iterable<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return clazzRepository.findById(id);
    }


}