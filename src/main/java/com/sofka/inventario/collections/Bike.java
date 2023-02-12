package com.sofka.inventario.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document("bike")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
