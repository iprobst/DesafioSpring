package com.meli.desafiospring.searchengine.service.sale;

import com.meli.desafiospring.searchengine.dto.article.ArticleDTO;
import com.meli.desafiospring.searchengine.dto.sale.*;
import com.meli.desafiospring.searchengine.exceptions.BadRequestException;
import com.meli.desafiospring.searchengine.exceptions.StatusCodeDTO;
import com.meli.desafiospring.searchengine.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{

    private static int saleId = 0;

    private final ArticleRepository articleRepository;

    private final ShopingCart shopingCart ;

    public SaleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.shopingCart = new ShopingCart();
    }

    @Override
    public PurchaseResponseDTO purchaseRequest(PurchaseRequestDTO purchaseRequestDTO) {

        PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();

        purchaseResponseDTO.setReceipt(generateReceipt(purchaseRequestDTO));

        purchaseResponseDTO.setShopingCart(totalShopingCart());

        purchaseResponseDTO.setStatusCode(new StatusCodeDTO(200, "la solicitud se completo con exito."));

        return purchaseResponseDTO;
    }

    public ShopingCart totalShopingCart(){
        return shopingCart;
    }

    private ReceiptDTO generateReceipt(PurchaseRequestDTO purchaseRequestDTO){

        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setId(saleId++);
        receiptDTO.setStatus("PENDING");
        receiptDTO.setArticles(getArticlesById(purchaseRequestDTO.getArticles()));
        Double total = totalPrice(purchaseRequestDTO.getArticles());
        receiptDTO.setTotalPrice(total);
        Double totalCart = this.shopingCart.getTotal() + total;
        this.shopingCart.setTotal(totalCart);

        return receiptDTO;
    }

    private List<ArticleResponse> getArticlesById(List<InfoArticleDTO> infoArticles){
        List<ArticleResponse> articlesList = new ArrayList<>();
        for(InfoArticleDTO info: infoArticles){
                ArticleDTO article = articleRepository.findArticleById(info.getProductId());
            if(info.getQuantity() > article.getQuantity()){
                String mensaje = "Stock insuficiente del producto con id(" + article.getId()
                        + "). Stock disponible: " + article.getQuantity()
                        + ". Stock requerido: " + info.getQuantity();
                throw new BadRequestException(mensaje);
            }
                articlesList.add(createArticleResponse(info,article));
        }
        return articlesList;
    }

    private Double totalPrice(List<InfoArticleDTO> infoArticles){

        Double total = 0.0;

        for (InfoArticleDTO info : infoArticles){

            ArticleDTO currentArticle = articleRepository.findArticleById(info.getProductId());

            Double unitPrice = currentArticle.getPrice();
            total +=(unitPrice * info.getQuantity()) * ((100 - info.getDiscount()) / 100);

        }

        return total;
    }

    private ArticleResponse createArticleResponse(InfoArticleDTO info, ArticleDTO article){
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setId(article.getId());
        articleResponse.setProducto(article.getName() + " " + article.getBrand());
        articleResponse.setPrice(article.getPrice());
        articleResponse.setDiscount(info.getDiscount());
        articleResponse.setQuantity(info.getQuantity());
        return articleResponse;
    }

    private void updateStockArticle(ArticleDTO articleDTO){
        articleRepository.updateDataBase(articleDTO);
    }

}
