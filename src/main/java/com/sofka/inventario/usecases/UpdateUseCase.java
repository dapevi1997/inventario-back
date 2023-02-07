package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.repositories.BikeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class UpdateUseCase {
    @Autowired
    private BikeRepository bikeRepository;
    public Mono<String> updateBike(Bike bike){
        return bikeRepository.save(bike)
                .map(Bike::getId);

    }
}
