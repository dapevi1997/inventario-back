package com.sofka.inventario.utilities;

import com.sofka.inventario.model.ValidateBikeDTOModel;
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

    public ValidateBikeDTOModel validateBikeDTO(BikeDTO bikeDTO){
        if(!stringNotBlankAndNotNull(bikeDTO.getName())){
            return new ValidateBikeDTOModel("El nombre es requerido",false);
        }
        if(!isNotNull(bikeDTO.getInInventory())){
            return new ValidateBikeDTOModel("El número en inventario es requerido",false);
        }
        if(!isNotNull(bikeDTO.getEnabled())){
            return new ValidateBikeDTOModel("Indique si quiere que la bicicleta esté disponible al público",false);
        }
        if(!isNotNull(bikeDTO.getMin())){
            return new ValidateBikeDTOModel("Indique el número mínimo que desea tener en stock",false);
        }
        if(!isNotNull(bikeDTO.getMax())){
            return new ValidateBikeDTOModel("Indique el número máximo disponible al público",false);
        }
        if (bikeDTO.getMin()<8){
            return new ValidateBikeDTOModel("El número mínimo de unidades debe ser 8",false);
        }
        if (bikeDTO.getMax()>200){
            return new ValidateBikeDTOModel("El número máximo de unidades por cliente debe ser máximo 200",false);
        }
        if(!stringNotBlankAndNotNull(bikeDTO.getUrlImage())){
            return new ValidateBikeDTOModel("La imágen es requerida",false);
        }
        if(!isNotNull(bikeDTO.getPrecio())){
            return new ValidateBikeDTOModel("El precio es requerido",false);
        }
        return new ValidateBikeDTOModel("",true);
    }

}
