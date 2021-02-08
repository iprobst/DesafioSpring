package com.meli.desafiospring.searchengine.exceptions;

public class BadRequestException extends RuntimeException{

    private static final String DESCRIPTION = "Bad Request Exception (400)";

    public BadRequestException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
