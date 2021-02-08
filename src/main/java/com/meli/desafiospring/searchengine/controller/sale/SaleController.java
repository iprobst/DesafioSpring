package com.meli.desafiospring.searchengine.controller.sale;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;
import com.meli.desafiospring.searchengine.dto.sale.PurchaseRequestDTO;
import com.meli.desafiospring.searchengine.dto.sale.PurchaseResponseDTO;
import com.meli.desafiospring.searchengine.dto.sale.ShopingCart;
import com.meli.desafiospring.searchengine.service.sale.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v2/purchase-request")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    @ResponseBody
    public PurchaseResponseDTO getAllArticles(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
       return saleService.purchaseRequest(purchaseRequestDTO);
    }

    @GetMapping("/total")
    public ShopingCart totalShopingCart() {
        return saleService.totalShopingCart();
    }

}
