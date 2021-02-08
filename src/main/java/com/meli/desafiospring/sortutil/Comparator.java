package com.meli.desafiospring.sortutil;

import com.meli.desafiospring.dto.article.ArticleDTO;

public interface Comparator {

    double compare(ArticleDTO a, ArticleDTO b);

}
