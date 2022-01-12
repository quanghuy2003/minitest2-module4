package com.example.minitest2.controller;

import com.example.minitest2.model.Post;
import com.example.minitest2.model.Test;
import com.example.minitest2.model.Test2;
import com.example.minitest2.service.Test2Service;
import com.example.minitest2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tests")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping
    public ResponseEntity<Iterable<Test>> findByMode() {
        List<Test> tests = (List<Test>) testService.findAll();
        if (tests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Test> add(@RequestBody Test test) {
        testService.save(test);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> findById(@PathVariable Long id) {
        return new ResponseEntity<>(testService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> update(@PathVariable Long id, @RequestBody Test test) {
        Optional<Test> testOptional = testService.findById(id);
        test.setId(testOptional.get().getId());
        testService.save(test);
        return new ResponseEntity<>(testOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Test> delete(@PathVariable Long id) {
        Optional<Test> test = testService.findById(id);
        if (!test.isPresent()) {
            return new ResponseEntity<>(test.get(), HttpStatus.NOT_FOUND);
        }
        testService.remove(id);
        return new ResponseEntity<>(test.get(), HttpStatus.NO_CONTENT);
    }
}
