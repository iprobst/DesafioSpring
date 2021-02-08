package com.meli.desafiospring.searchengine.service.sale;

import com.meli.desafiospring.searchengine.dto.sale.PurchaseResponseDTO;
import com.meli.desafiospring.searchengine.dto.sale.PurchaseRequestDTO;
import com.meli.desafiospring.searchengine.dto.sale.ShopingCart;

public interface SaleService {

    PurchaseResponseDTO purchaseRequest(PurchaseRequestDTO purchaseRequestDTO);

    ShopingCart totalShopingCart();
}
