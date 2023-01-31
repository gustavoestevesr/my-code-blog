package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.PostModel;
import com.spring.codeblog.service.BlogService;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value="/error", method=RequestMethod.GET)
    public String getSomeError(){
        return "error";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts"); // nome da pagina
        List<PostModel> posts = blogService.findAll();
        mv.addObject("posts", posts); // nome do atributo para renderizar conteudo
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostByID(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("postDetails"); // nome da pagina
        PostModel post = blogService.findById(id);
        mv.addObject("post", post); // nome do atributo para renderizar conteudo
        return mv;
    }

    // @RequestMapping(value = "/posts/title", method = RequestMethod.GET)    
    // public ModelAndView getPostByTitle(@RequestParam("title") String title) {
    //     ModelAndView mv = new ModelAndView("posts"); // nome da pagina
    //     List<PostModel> posts = blogService.findByTitle(title);
    //     mv.addObject("post", posts); // nome do atributo para renderizar conteudo
    //     return mv;
    // }

    @RequestMapping(value = "/posts/id", method = RequestMethod.GET)    
    public ModelAndView getPostByTitle(@RequestParam("id") Long id) {
        ModelAndView mv = new ModelAndView("postDetails"); // nome da pagina
        PostModel post = blogService.findById(id);
        mv.addObject("post", post); // nome do atributo para renderizar conteudo
        return mv;
    }

    @RequestMapping(value="/newpost", method=RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Validated PostModel post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setCreatedAt(LocalDate.now());
        blogService.save(post);
        attributes.addFlashAttribute("message", "Post cadastro com sucesso!");
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletepost/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") Long id, RedirectAttributes attributes) {
        blogService.delete(id);
        attributes.addFlashAttribute("message", "Post removido com sucesso!");
        return "redirect:/posts";
    }
    
}
