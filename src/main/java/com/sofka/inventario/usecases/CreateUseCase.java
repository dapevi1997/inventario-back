package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.model.BikeDTO;
import com.sofka.inventario.repositories.BikeRepository;
import com.sofka.inventario.utilities.MapperUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class CreateUseCase {
    @Autowired
    private BikeRepository bikeRepository;
    @Autowired
    private MapperUtils mapperUtils;

    public Mono<Bike> saveBike(BikeDTO bikeDTO){
       Bike bike = mapperUtils.mapperToBike().apply(bikeDTO);
        return bikeRepository.save(bike);
    }

}
