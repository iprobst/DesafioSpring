package com.meli.desafiospring.searchengine.dto.sale;

public class ShopingCart {

    private Double total;

    public ShopingCart() {
        this.total = 0.0;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
