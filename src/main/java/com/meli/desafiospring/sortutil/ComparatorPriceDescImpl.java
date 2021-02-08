package com.meli.desafiospring.sortutil;

import com.meli.desafiospring.dto.article.ArticleDTO;

public class ComparatorPriceDescImpl implements Comparator {
    @Override
    public double compare(ArticleDTO a, ArticleDTO b) {
        return b.getPrice() - a.getPrice();
    }
}
