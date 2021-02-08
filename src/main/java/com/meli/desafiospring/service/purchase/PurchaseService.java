package com.meli.desafiospring.service.purchase;

import com.meli.desafiospring.dto.purchase.PurchaseResponseDTO;
import com.meli.desafiospring.dto.purchase.PurchaseRequestDTO;
import com.meli.desafiospring.dto.purchase.ShopingCartDTO;

public interface PurchaseService {

    PurchaseResponseDTO purchaseRequest(PurchaseRequestDTO purchaseRequestDTO);

    ShopingCartDTO totalShopingCart();
}
