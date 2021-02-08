package com.meli.desafiospring.searchengine.sortutil;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

public class ComparatorNameDescImpl implements Comparator {
    @Override
    public double compare(ArticleDTO a, ArticleDTO b) {
        return b.getName().toUpperCase().compareTo(a.getName().toUpperCase());
    }
}
