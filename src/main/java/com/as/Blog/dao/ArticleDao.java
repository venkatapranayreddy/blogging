package com.as.Blog.dao;


import com.as.Blog.model.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArticleDao extends JpaRepository<ArticleModel, Long> {
//    List<ArticleModel> findById();

//    Optional<ArticleModel> findByTitle(String title);

    @Query("SELECT a FROM ArticleModel a WHERE LOWER(a.title) = LOWER(:title)")
    Optional<ArticleModel> findByTitle(@Param("title") String title);
}
