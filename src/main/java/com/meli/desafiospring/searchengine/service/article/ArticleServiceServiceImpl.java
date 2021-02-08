package com.meli.desafiospring.searchengine.service.article;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;
import com.meli.desafiospring.searchengine.filterutil.FilterUtil;
import com.meli.desafiospring.searchengine.repositories.ArticleRepository;
import com.meli.desafiospring.searchengine.sortutil.SortUtil;
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

        articles = FilterUtil.filterBy(articles, category,freeShipping);

        articles = SortUtil.sortBy(articles, order);

        return articles;
    }




}
