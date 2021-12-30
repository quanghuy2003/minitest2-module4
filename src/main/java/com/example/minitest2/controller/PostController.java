package com.example.minitest2.controller;

import com.example.minitest2.model.Post;
import com.example.minitest2.service.ModeService;
import com.example.minitest2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posts")
public class PostController {
@Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Post>> findAllMode() {
        List<Post> modes = (List<Post>) postService.findAll();
        if (modes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(modes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> add(@RequestBody Post post) {
        post.setTime(LocalDateTime.now());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        Optional<Post> postOptional = postService.findById(id);
        post.setId(postOptional.get().getId());
        postService.save(post);
        return new ResponseEntity<>(postOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> delete(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()) {
            return new ResponseEntity<>(post.get(), HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(post.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findAllMode")
    public ResponseEntity<Iterable<Post>> findAllModeid() {
        List<Post> modes = (List<Post>) postService.findByModeId();
        if (modes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(modes, HttpStatus.OK);
    }

}
