package com.example.minitest2.controller;

import com.example.minitest2.model.Mode;
import com.example.minitest2.model.Test2;
import com.example.minitest2.service.ModeService;
import com.example.minitest2.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test2s")
public class Test2Controller {
    @Autowired
    Test2Service test2Service;

    @GetMapping
    public ResponseEntity<Iterable<Test2>> findByMode() {
        List<Test2> test2s = (List<Test2>) test2Service.findAll();
        if (test2s.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(test2s, HttpStatus.OK);
    }
}
