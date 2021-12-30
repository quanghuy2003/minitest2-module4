package com.example.minitest2.service;

import com.example.minitest2.model.Post;
import org.springframework.data.repository.query.Param;

public interface IPostService extends IService<Post> {
    Iterable<Post> findByModeId();

}
