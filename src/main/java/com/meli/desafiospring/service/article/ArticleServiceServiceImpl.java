package com.meli.desafiospring.service.article;

import com.meli.desafiospring.dto.article.ArticleDTO;
import com.meli.desafiospring.filterutil.FilterUtil;
import com.meli.desafiospring.repositories.ArticleRepository;
import com.meli.desafiospring.sortutil.Heapsort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleServiceServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDTO> filterAndSortArticles(Optional<String> category, Optional<Integer> freeShipping, Optional<Integer> order){

        List<ArticleDTO> articles = new ArrayList<>();

        articles.addAll(articleRepository.getAll());

        articles = FilterUtil.filter(articles, category,freeShipping);

        articles = Heapsort.sortArticleList(articles, order);

        return articles;
    }




}
