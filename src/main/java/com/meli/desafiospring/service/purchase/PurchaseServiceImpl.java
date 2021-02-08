package com.meli.desafiospring.service.purchase;

import com.meli.desafiospring.dto.article.ArticleDTO;
import com.meli.desafiospring.dto.purchase.*;
import com.meli.desafiospring.exceptions.BadRequestException;
import com.meli.desafiospring.exceptions.StatusCodeDTO;
import com.meli.desafiospring.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final ArticleRepository articleRepository;

    private final ShopingCartDTO shopingCartDTO;

    public PurchaseServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.shopingCartDTO = new ShopingCartDTO();
    }

    @Override
    public PurchaseResponseDTO purchaseRequest(PurchaseRequestDTO purchaseRequestDTO) {

        PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();

        purchaseResponseDTO.setReceipt(generateReceipt(purchaseRequestDTO));

        purchaseResponseDTO.setShopingCart(totalShopingCart());

        purchaseResponseDTO.setStatusCode(new StatusCodeDTO(200, "la solicitud se completo con exito."));

        return purchaseResponseDTO;
    }

    public ShopingCartDTO totalShopingCart(){
        return shopingCartDTO;
    }

    private ReceiptDTO generateReceipt(PurchaseRequestDTO purchaseRequestDTO){

        ReceiptDTO receiptDTO = new ReceiptDTO();
        Double total = totalPrice(purchaseRequestDTO.getArticles());

        receiptDTO.setStatus("PENDING");
        receiptDTO.setArticles(getArticles(purchaseRequestDTO.getArticles()));
        receiptDTO.setTotalPrice(total);

        Double totalCart = this.shopingCartDTO.getTotal() + total;
        this.shopingCartDTO.setTotal(totalCart);

        return receiptDTO;
    }

    private List<ArticleResponse> getArticles(List<InfoArticleDTO> infoArticles){

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

            total +=(currentArticle.getPrice() * info.getQuantity()) * ((100 - info.getDiscount()) / 100);

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
        articleRepository.updateArticleDB(articleDTO);
    }

}
