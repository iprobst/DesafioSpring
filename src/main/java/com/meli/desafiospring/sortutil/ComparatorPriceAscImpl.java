package com.meli.desafiospring.sortutil;

import com.meli.desafiospring.dto.article.ArticleDTO;

public class ComparatorPriceAscImpl implements Comparator {
    @Override
    public double compare(ArticleDTO a, ArticleDTO b) {
        return a.getPrice()-b.getPrice();
    }
}
