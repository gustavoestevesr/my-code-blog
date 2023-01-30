package com.spring.codeblog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.codeblog.model.PostModel;
import com.spring.codeblog.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository postRepository;

    public BlogServiceImpl(BlogRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostModel> findAll() {        
        return postRepository.findAll();
    }

    @Override
    public PostModel save(PostModel postModel) {        
        return postRepository.save(postModel);
    }

    @Override
    public void delete(Long id) {        
        postRepository.deleteById(id);
    }

    @Override
    public PostModel findById(Long id) {
        return postRepository.findById(id).get();
    }
    
}
