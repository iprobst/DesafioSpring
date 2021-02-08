package com.meli.desafiospring.searchengine.sortutil;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

public class ComparatorPriceAscImpl implements Comparator {
    @Override
    public double compare(ArticleDTO a, ArticleDTO b) {
        return a.getPrice()-b.getPrice();
    }
}
