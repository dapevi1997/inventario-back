package com.sofka.inventario.usecases;

import com.sofka.inventario.model.BikeDTO;
import com.sofka.inventario.repositories.BikeRepository;
import com.sofka.inventario.utilities.MapperUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Data
public class GetByIdUseCase implements Function<String, Mono<BikeDTO>> {
    @Autowired
    private BikeRepository bikeRepository;
    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public Mono<BikeDTO> apply(String id) {
        return bikeRepository.findById(id).map(mapperUtils.mapEntityToBikeDTO());
    }
}
