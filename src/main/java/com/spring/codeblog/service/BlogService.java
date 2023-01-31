package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.PostModel;

public interface BlogService {
    
    public List<PostModel> findAll();
    public PostModel save(PostModel postModel);
    public void delete(Long id);
    public PostModel findById(Long id);
    public List<PostModel> findByTitle(String title);

}
