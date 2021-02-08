package com.meli.desafiospring.dto.purchase;

import com.meli.desafiospring.exceptions.StatusCodeDTO;

public class PurchaseResponseDTO {
    private ReceiptDTO receipt;
    private StatusCodeDTO statusCode;
    private ShopingCartDTO shopingCartDTO;

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

    public ShopingCartDTO getShopingCart() {
        return shopingCartDTO;
    }

    public void setShopingCart(ShopingCartDTO shopingCartDTO) {
        this.shopingCartDTO = shopingCartDTO;
    }
}
