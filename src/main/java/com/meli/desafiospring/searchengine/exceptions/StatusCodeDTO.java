package com.meli.desafiospring.searchengine.exceptions;

public class StatusCodeDTO {
    private Integer code;
    private String message;

    public StatusCodeDTO() {
    }

    public StatusCodeDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
