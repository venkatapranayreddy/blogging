package com.as.Blog.service;

import com.as.Blog.model.ArticleModel;
import com.as.Blog.dao.ArticleDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleDao articleDao;





//    public ResponseEntity<?> authArticle(String token) {
//        String showArticle = articleInterface.confirm(token).getBody();
////        String sample = restTemplate.getForObject(url, class);
//
//        if ("confirmed".equals(showArticle)){
//
//            return getAllArticle(token);
//    } else
//
//    {
//        return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
//    }
//    }


//Create Operation
    public ArticleModel createArticle(ArticleModel articleModel) {
        if(articleModel.getId() == null){
            articleModel.setDate(LocalDateTime.now());
        }
        return  articleDao.save(articleModel);
    }



//Request Operation
    public ResponseEntity<List<ArticleModel>> getAllArticle() {
        try {
            return new ResponseEntity<>(articleDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }



    //editById
    public ResponseEntity<Optional<ArticleModel>> getArticleById(Long id) {
        try {
            Optional<ArticleModel> article = articleDao.findById(id);
            if (article.isPresent()) {
                return new ResponseEntity<>(article, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
        }
    }




    public ResponseEntity<Optional<ArticleModel>> getArticleByTitle(String title) {
//        String showArticle = articleInterface.confirm(token).getBody();
        try {
            Optional<ArticleModel> article = articleDao.findByTitle(title);
            if (article.isPresent()) {
                return new ResponseEntity<>(article, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
        }
    }






    //Update Operation
    public ResponseEntity<String> updateTheArticle(Long id, ArticleModel updatedArticle ) {
        Optional<ArticleModel> article =  articleDao.findById(id);
        if(article.isPresent()) {
            ArticleModel art = article.get();
            art.setDate(updatedArticle.getDate());
            art.setTitle(updatedArticle.getTitle());
            art.setDescription(updatedArticle.getDescription());
            articleDao.save(art);
            return new ResponseEntity<>("updated sucessfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("articleUpdateError", HttpStatus.BAD_REQUEST);
        }

    }
}
