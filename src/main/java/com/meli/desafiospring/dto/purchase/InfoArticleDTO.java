package com.meli.desafiospring.dto.purchase;

import com.meli.desafiospring.exceptions.BadRequestException;

public class InfoArticleDTO {

    private Integer productId;
    private Double discount;
    private Integer quantity;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        if(discount > 100 || discount< 0){
            throw new BadRequestException("Descuento invalido del producto con id("
                    + getProductId() + "). El descuento tiene que ser entre 0 y 100." +
                    "Descuento actual: " + discount);
        }

        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
