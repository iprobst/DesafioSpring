package com.meli.desafiospring.controller.purchase;

import com.meli.desafiospring.dto.purchase.PurchaseRequestDTO;
import com.meli.desafiospring.dto.purchase.PurchaseResponseDTO;
import com.meli.desafiospring.dto.purchase.ShopingCartDTO;
import com.meli.desafiospring.service.purchase.PurchaseService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2/purchase-request")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseBody
    public PurchaseResponseDTO getAllArticles(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
       return purchaseService.purchaseRequest(purchaseRequestDTO);
    }

    @GetMapping("/shopping-cart")
    public ShopingCartDTO totalShopingCart() {
        return purchaseService.totalShopingCart();
    }

}
