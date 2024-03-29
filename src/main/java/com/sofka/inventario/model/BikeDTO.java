package com.sofka.inventario.model;

import lombok.Data;

import java.util.Objects;


@Data
public class BikeDTO {

    private String name;

    private Long inInventory;

    private Boolean enabled;

    private Long min;

    private Long max;

    private String urlImage;

    private Double precio;

    public BikeDTO(String name, Long inInventory, Boolean enabled, Long min, Long max, String urlImage, Double precio) {
        this.name = name;
        this.inInventory = inInventory;
        this.enabled = enabled;
        this.min = min;
        this.max = max;
        this.urlImage = urlImage;
        this.precio = precio;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BikeDTO bikeDTO = (BikeDTO) o;
        return Objects.equals(name, bikeDTO.name) && Objects.equals(inInventory, bikeDTO.inInventory) && Objects.equals(enabled, bikeDTO.enabled) && Objects.equals(min, bikeDTO.min) && Objects.equals(max, bikeDTO.max) && Objects.equals(urlImage, bikeDTO.urlImage) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inInventory, enabled, min, max, urlImage);
    }
}
