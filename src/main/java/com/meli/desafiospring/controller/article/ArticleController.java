package com.meli.desafiospring.controller.article;

import com.meli.desafiospring.dto.article.ArticleDTO;
import com.meli.desafiospring.service.article.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles")
public class  ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public List<ArticleDTO> getAllArticles(@RequestParam Optional<String> category,@RequestParam Optional<Integer> freeShipping, @RequestParam Optional<Integer> order) {
        return articleService.filterAndSortArticles(category, freeShipping, order);
    }
}
