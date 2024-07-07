package com.as.Blog.controller;


import com.as.Blog.service.ArticleService;
import com.as.Blog.model.ArticleModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RestController
@RequestMapping("Article")
public class ArticleController {

    @Autowired
    ArticleService articleService;





    @PostMapping("Create")
    public String createArticle(@RequestBody ArticleModel articleModel) {
         articleService.createArticle(articleModel);
        return "redirect:/";
    }




    @GetMapping("/All")
    public  ResponseEntity<List<ArticleModel>> getAllArticle(){
        return articleService.getAllArticle();
    }


//byid
    @GetMapping("id/{id}")
    public  ResponseEntity<Optional<ArticleModel>> getArticleById(@PathVariable(value="id") Long id){
        return articleService.getArticleById(id);
    }

    @GetMapping("/title/{title}")
    public  ResponseEntity<Optional<ArticleModel>> getArticleByTitle(@PathVariable(value="title") String title){
        return articleService.getArticleByTitle(title);
    }



    @PutMapping("/Edit/{id}")
    public ResponseEntity<String> updateTheArticle(@PathVariable(value="id") Long id, @RequestBody ArticleModel articleModel ){
        return articleService.updateTheArticle(
                id,
                articleModel);
    }




}
