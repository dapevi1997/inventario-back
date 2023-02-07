package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.repositories.BikeRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
@Slf4j
public class LogicalDeleteUseCase {
    @Autowired
    private BikeRepository bikeRepository;

    public Mono<Bike> logicDelete(String id){
        log.info(id);
        return  bikeRepository.findById(id)
                .map(bike -> {
                    bike.setState(Boolean.FALSE);
                    return bike;
                });
    }
}
