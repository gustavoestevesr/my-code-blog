package com.spring.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblog.model.PostModel;

public interface BlogRepository extends JpaRepository<PostModel, Long> {
    
}
