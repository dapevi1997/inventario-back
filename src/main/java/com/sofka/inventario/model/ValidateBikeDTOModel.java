package com.sofka.inventario.model;

import lombok.Data;

@Data
public class ValidateBikeDTOModel {

    private Boolean isValid;
    private String message;

    public ValidateBikeDTOModel(String message, Boolean isValid) {
        this.message = message;
        this.isValid = isValid;
    }
}
