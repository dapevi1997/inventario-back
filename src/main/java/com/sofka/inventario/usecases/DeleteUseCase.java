package com.sofka.inventario.usecases;

import com.sofka.inventario.repositories.BikeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class DeleteUseCase {
    @Autowired
    private BikeRepository bikeRepository;

    public Mono<Void> apply(String id){
        return bikeRepository.deleteById(id);
    }


}
