package com.meli.desafiospring.service.article;

import com.meli.desafiospring.dto.article.ArticleDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    public List<ArticleDTO> filterAndSortArticles(Optional<String> category, Optional<Integer> freeShipping, Optional<Integer> order);

}
