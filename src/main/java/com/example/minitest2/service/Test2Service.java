package com.example.minitest2.service;

import com.example.minitest2.model.Test2;
import com.example.minitest2.repository.Test2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Test2Service implements ITest2Service{
    @Autowired
    private Test2Repository test2Repository;
    @Override
    public void save(Test2 test2) {
        test2Repository.save(test2);
    }

    @Override
    public Iterable<Test2> findAll() {
        return test2Repository.findAll();
    }

    @Override
    public Optional<Test2> findById(Long id) {
        return test2Repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        test2Repository.deleteById(id);
    }
}
