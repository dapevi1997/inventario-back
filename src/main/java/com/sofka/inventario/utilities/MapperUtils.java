package com.sofka.inventario.utilities;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.model.BikeDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<BikeDTO, Bike> mapperToBike(){
        return bikeDTO -> {
            Bike bike = new Bike();
            bike.setName(bikeDTO.getName());
            bike.setInInventory(bikeDTO.getInInventory());
            bike.setEnabled(bikeDTO.getEnabled());
            bike.setMin(bikeDTO.getMin());
            bike.setMax(bikeDTO.getMax());
            bike.setUrlImage(bikeDTO.getUrlImage());
            bike.setState(bikeDTO.getState());
            return bike;
        };
    }
}
