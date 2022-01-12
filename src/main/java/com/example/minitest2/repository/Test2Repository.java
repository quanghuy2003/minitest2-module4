package com.example.minitest2.repository;

import com.example.minitest2.model.Test2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Test2Repository extends CrudRepository<Test2,Long> {
}
