package com.sofka.inventario.utilities;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.model.ValidateBikeModel;
import com.sofka.inventario.model.BikeDTO;
import org.springframework.stereotype.Component;


@Component
public class Validations {
    public Boolean stringNotBlankAndNotNull(String string){
       if (string == null | string == ""){
           return false;
       }

        return true;

    }

    public Boolean isNotNull(Object o){
        if (o == null){
            return false;
        }

        return true;
    }

    public ValidateBikeModel validateBikeDTO(BikeDTO bikeDTO){
        if(!stringNotBlankAndNotNull(bikeDTO.getName())){
            return new ValidateBikeModel("El nombre es requerido",false);
        }
        if(!isNotNull(bikeDTO.getInInventory())){
            return new ValidateBikeModel("El número en inventario es requerido",false);
        }
        if(!isNotNull(bikeDTO.getEnabled())){
            return new ValidateBikeModel("Indique si quiere que la bicicleta esté disponible al público",false);
        }
        if(!isNotNull(bikeDTO.getMin())){
            return new ValidateBikeModel("Indique el número mínimo que desea tener en stock",false);
        }
        if(!isNotNull(bikeDTO.getMax())){
            return new ValidateBikeModel("Indique el número máximo disponible al público",false);
        }
        if (bikeDTO.getMin()<8){
            return new ValidateBikeModel("El número mínimo de unidades debe ser 8",false);
        }
        if (bikeDTO.getMax()>200){
            return new ValidateBikeModel("El número máximo de unidades por cliente debe ser máximo 200",false);
        }
        if(!stringNotBlankAndNotNull(bikeDTO.getUrlImage())){
            return new ValidateBikeModel("La imágen es requerida",false);
        }
        if(!isNotNull(bikeDTO.getPrecio())){
            return new ValidateBikeModel("El precio es requerido",false);
        }
        return new ValidateBikeModel("",true);
    }

    public ValidateBikeModel validateBike(Bike bike){
        if(!stringNotBlankAndNotNull(bike.getId())){
            return new ValidateBikeModel("El id es requerido",false);
        }
        if(!stringNotBlankAndNotNull(bike.getName())){
            return new ValidateBikeModel("El nombre es requerido",false);
        }
        if(!isNotNull(bike.getInInventory())){
            return new ValidateBikeModel("El número en inventario es requerido",false);
        }
        if(!isNotNull(bike.getEnabled())){
            return new ValidateBikeModel("Indique si quiere que la bicicleta esté disponible al público",false);
        }
        if(!isNotNull(bike.getMin())){
            return new ValidateBikeModel("Indique el número mínimo que desea tener en stock",false);
        }
        if(!isNotNull(bike.getMax())){
            return new ValidateBikeModel("Indique el número máximo disponible al público",false);
        }
        if (bike.getMin()<8){
            return new ValidateBikeModel("El número mínimo de unidades debe ser 8",false);
        }
        if (bike.getMax()>200){
            return new ValidateBikeModel("El número máximo de unidades por cliente debe ser máximo 200",false);
        }
        if(!stringNotBlankAndNotNull(bike.getUrlImage())){
            return new ValidateBikeModel("La imágen es requerida",false);
        }
        if(!isNotNull(bike.getPrecio())){
            return new ValidateBikeModel("El precio es requerido",false);
        }
        return new ValidateBikeModel("",true);
    }

}
