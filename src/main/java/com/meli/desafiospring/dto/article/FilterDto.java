package com.meli.desafiospring.dto.article;

import java.util.HashMap;
import java.util.Optional;

public class FilterDto {

    HashMap<String, Optional<Object>> filter;

    public FilterDto() {
        filter = new HashMap<>();
    }

    public HashMap<String, Optional<Object>> getFilter() {
        return filter;
    }

    public void setFilter(String nameFilter, Optional<Object> query) {
        this.filter.put(nameFilter, query);
    }

    public void filter(){

        filter.forEach((s, o) -> {
            if(o.isPresent()){

            }
        });

    }



}
