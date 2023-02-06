package com.sofka.inventario.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

}
