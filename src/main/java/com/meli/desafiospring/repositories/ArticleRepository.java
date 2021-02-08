package com.meli.desafiospring.repositories;

import com.meli.desafiospring.dto.article.ArticleDTO;

import java.util.List;

public interface ArticleRepository {

    ArticleDTO findArticleById(Integer id);

    List<ArticleDTO> getAll();

    void updateArticleDB(ArticleDTO updateArticle);

}
