package com.meli.desafiospring.searchengine.dto.sale;

import com.meli.desafiospring.searchengine.exceptions.StatusCodeDTO;

public class PurchaseResponseDTO {
    private ReceiptDTO receipt;
    private StatusCodeDTO statusCode;
    private ShopingCart shopingCart;

    public ReceiptDTO getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDTO receipt) {
        this.receipt = receipt;
    }

    public StatusCodeDTO getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCodeDTO statusCode) {
        this.statusCode = statusCode;
    }

    public ShopingCart getShopingCart() {
        return shopingCart;
    }

    public void setShopingCart(ShopingCart shopingCart) {
        this.shopingCart = shopingCart;
    }
}
