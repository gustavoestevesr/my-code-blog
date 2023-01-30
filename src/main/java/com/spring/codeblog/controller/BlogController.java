package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.model.PostModel;
import com.spring.codeblog.service.BlogService;
// import com.spring.codeblog.web.servlet;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts"); // nome da pagina
        List<PostModel> posts = blogService.findAll();
        mv.addObject("posts", posts); // nome do atributo para renderizar conteudo
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostsByID(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("postDetails"); // nome da pagina
        PostModel post = blogService.findById(id);
        mv.addObject("post", post); // nome do atributo para renderizar conteudo
        return mv;
    }
    
}
