package com.sofka.inventario.collections;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Document("bike")
@Data
public class Bike {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private Long inInventory;
    @Field
    private Boolean enabled;
    @Field
    private Long min;
    @Field
    private Long max;
    @Field
    private String urlImage;
    @Field
    private Boolean state;
    @Field
    private Double precio;

}
