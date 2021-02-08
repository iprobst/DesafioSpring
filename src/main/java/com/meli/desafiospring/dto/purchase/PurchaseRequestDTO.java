package com.meli.desafiospring.dto.purchase;

import java.util.List;

public class PurchaseRequestDTO {
    private String userName;
    private List<InfoArticleDTO> articles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<InfoArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<InfoArticleDTO> articles) {
        this.articles = articles;
    }
}
