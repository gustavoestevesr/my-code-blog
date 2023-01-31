package com.spring.codeblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.codeblog.model.PostModel;

public interface BlogRepository extends JpaRepository<PostModel, Long> {

    // List<PostModel> findByTitle(String title);

    //Custom query
    @Query(value = "select * from TB_POST p where p.title like %:title%", nativeQuery = true)
    List<PostModel> findByTitle(@Param("title") String title);
    
}
