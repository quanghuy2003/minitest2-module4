package com.example.minitest2.service;

import com.example.minitest2.model.Test;
import com.example.minitest2.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TestService implements ITestService{

    @Autowired
    private TestRepository testRepository;
    @Override
    public void save(Test test) {
    testRepository.save(test);
    }

    @Override
    public Iterable<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        testRepository.deleteById(id);
    }
}
