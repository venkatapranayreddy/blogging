package com.as.Blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
//@EnableFeignClients(basePackages = "com.as.Blog.feign")
////@ComponentScan(basePackages = "com.article_service.articleservice")
public class ArticleserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleserviceApplication.class, args);
	}

}
