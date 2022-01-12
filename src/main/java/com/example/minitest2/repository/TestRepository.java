package com.example.minitest2.repository;

import com.example.minitest2.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test,Long> {
}
