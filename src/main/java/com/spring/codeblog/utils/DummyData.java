package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.codeblog.model.PostModel;
import com.spring.codeblog.repository.BlogRepository;

@Component
public class DummyData {
    
    private final BlogRepository blogRepository;

    public DummyData(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    // Apenas 1 vez para execução da populacao de dados
    // @PostConstruct
    public void savePosts(){

        List<PostModel> postList = new ArrayList<>();
        PostModel post1 = new PostModel();
        post1.setAuthor("Bruno Alexandre");
        post1.setCreatedAt(LocalDate.now());        
        post1.setTitle("Docker");
        post1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        PostModel post2 = new PostModel();
        post2.setAuthor("Michelli Brito");
        post2.setCreatedAt(LocalDate.now());
        post2.setTitle("API REST");
        post2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        postList.add(post1);
        postList.add(post2);

        for(PostModel post: postList){
            PostModel postSaved = blogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}

