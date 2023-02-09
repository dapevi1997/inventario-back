package com.sofka.inventario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.Objects;


@Data
@AllArgsConstructor
public class BikeDTO {

    private String name;

    private Long inInventory;

    private Boolean enabled;

    private Long min;

    private Long max;

    private String urlImage;

    private Boolean state;

    private Double precio;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BikeDTO bikeDTO = (BikeDTO) o;
        return Objects.equals(name, bikeDTO.name) && Objects.equals(inInventory, bikeDTO.inInventory) && Objects.equals(enabled, bikeDTO.enabled) && Objects.equals(min, bikeDTO.min) && Objects.equals(max, bikeDTO.max) && Objects.equals(urlImage, bikeDTO.urlImage) && Objects.equals(state, bikeDTO.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inInventory, enabled, min, max, urlImage, state);
    }
}
