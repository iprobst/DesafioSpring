package com.meli.desafiospring.searchengine.sortutil;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

public class ComparatorPriceDescImpl implements Comparator {
    @Override
    public double compare(ArticleDTO a, ArticleDTO b) {
        return b.getPrice() - a.getPrice();
    }
}
