package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.repositories.BikeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Data
public class ListUseCase {
    @Autowired
    private BikeRepository bikeRepository;
    public Flux<Bike> listByPage(int page){
        Pageable pageable = PageRequest.of(page,1);
        return bikeRepository.findAllByIdNotNullOrderByIdAsc(pageable);
    }

    public Flux<Bike> listAllBikes(){
        return bikeRepository.findAll();
    }
}
