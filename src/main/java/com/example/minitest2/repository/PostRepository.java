package com.example.minitest2.repository;

import com.example.minitest2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("select b from Post b where b.mode.id = 1 ")
    Iterable<Post> findByModeId();

}
