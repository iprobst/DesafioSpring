package com.meli.desafiospring.dto.purchase;

public class ShopingCartDTO {

    private Double total;

    public ShopingCartDTO() {
        this.total = 0.0;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
