package com.meli.desafiospring.searchengine.sortutil;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

public interface Comparator {

    double compare(ArticleDTO a, ArticleDTO b);

}
