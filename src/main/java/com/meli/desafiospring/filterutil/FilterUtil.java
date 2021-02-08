package com.meli.desafiospring.filterutil;

import com.meli.desafiospring.dto.article.ArticleDTO;
import com.meli.desafiospring.exceptions.BadRequestException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterUtil {

    public static List<ArticleDTO> findByFilterFreeShepping(Integer query, List<ArticleDTO> articles){
        if(query != 0 && query != 1)
            throw new BadRequestException("El envio gratis no puede ser diferente a 1 o 0. Numero ingresado: " + query);
        return articles.stream().filter(articleDTO -> articleDTO.getFreeShipping() == query).collect(Collectors.toList());
    }

    public static List<ArticleDTO> findAllByCategory(String query, List<ArticleDTO> articles) {
        List<ArticleDTO> articleDTOS = articles.stream().filter(articleDTO -> articleDTO.getCategory().equalsIgnoreCase(query)).collect(Collectors.toList());
        if(articleDTOS.size() <= 0)
            throw new BadRequestException("La categoria: " + query + " no existe");
        return articleDTOS;
    }

    public static List<ArticleDTO> filter(List<ArticleDTO> articles, Optional<String> category, Optional<Integer> freeShipping){

        if(category.isPresent()){
            articles = FilterUtil.findAllByCategory(category.get(), articles);
        }

        if(freeShipping.isPresent() && (freeShipping.get() == 1 || freeShipping.get() == 0)){
            articles = FilterUtil.findByFilterFreeShepping(freeShipping.get(), articles);
        }

        return articles;
    }

}
