package com.meli.desafiospring.searchengine.repositories;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    ArticleDTO findArticleById(Integer id);

    List<ArticleDTO> getAll();

    void updateDataBase(ArticleDTO updateArticle);

}
