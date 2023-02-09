package com.sofka.inventario.model;

import lombok.Data;

@Data
public class BadRequestModel {
    private String message;

    public BadRequestModel(String message) {
        this.message = message;
    }
}
