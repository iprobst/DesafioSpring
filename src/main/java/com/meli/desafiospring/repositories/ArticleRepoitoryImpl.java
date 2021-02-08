package com.meli.desafiospring.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafiospring.dto.article.ArticleDTO;
import com.meli.desafiospring.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepoitoryImpl implements ArticleRepository {

    private final List<ArticleDTO> database;

    public ArticleRepoitoryImpl() {
        this.database = loadDataBase();
    }

    @Override
    public List<ArticleDTO> getAll() {
        return database;
    }

    @Override
    public ArticleDTO findArticleById(Integer id) {
        Optional<ArticleDTO> articleDTO = database.stream().filter(articleDTO1 -> articleDTO1.getId() == id).findFirst();

        if(articleDTO.isEmpty())
            throw new BadRequestException("Producto con id " + id + " no encontrado");

        return articleDTO.get();
    }

    @Override
    public void updateArticleDB(ArticleDTO updateArticle){
        int index = this.database.indexOf(findArticleById(updateArticle.getId()));
        this.database.set(index, updateArticle);
        saveDataBase();
    }

    private List<ArticleDTO> loadDataBase() {

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:articles.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<ArticleDTO>> typeRef = new TypeReference<>() {};
        List<ArticleDTO> products = null;

        try {
            products = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    private void saveDataBase() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/articles.json"), this.database);
//            objectMapper.writeValue(new File("target/classes/com/articlesCopy.json"), this.database);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
