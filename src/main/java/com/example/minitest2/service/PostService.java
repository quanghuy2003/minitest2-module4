package com.example.minitest2.service;

import com.example.minitest2.model.Post;
import com.example.minitest2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService{

    @Autowired
    private PostRepository postRepository;


    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }


    @Override
    public Iterable<Post> findByModeId() {
        return postRepository.findByModeId();
    }
}
