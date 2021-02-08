package com.meli.desafiospring.searchengine.service.article;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    public List<ArticleDTO> filterAndSortArticles(Optional<String> category, Optional<Integer> freeShipping, Optional<Integer> order);

}
