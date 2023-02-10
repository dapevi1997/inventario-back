package com.sofka.inventario.model;

import lombok.Data;

@Data
public class ValidateBikeModel {

    private Boolean isValid;
    private String message;

    public ValidateBikeModel(String message, Boolean isValid) {
        this.message = message;
        this.isValid = isValid;
    }
}
