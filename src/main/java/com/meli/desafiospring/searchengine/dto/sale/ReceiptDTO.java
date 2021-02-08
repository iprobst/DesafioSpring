package com.meli.desafiospring.searchengine.dto.sale;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;

import java.util.List;

public class ReceiptDTO {

    private Integer id;
    private String status;
    private List<ArticleResponse> articles;
    private Double totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ArticleResponse> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleResponse> articles) {
        this.articles = articles;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
