package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.model.BikeDTO;
import com.sofka.inventario.repositories.BikeRepository;
import com.sofka.inventario.utilities.MapperUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateUseCaseTest {
    @SpyBean
    private CreateUseCase createUseCase;
    @Autowired
    private MapperUtils mapperUtils;
    @Mock
    BikeRepository bikeRepository;

    @Test
    void saveBike() {
        BikeDTO bikeDTO = new BikeDTO("nameBike",500L,true,8L,200L,"urlImage",2000000D);
        Bike bike = mapperUtils.mapperToBike().apply(bikeDTO);

        Mockito.when(bikeRepository.save(bike)).thenReturn(Mono.just(bike));

        StepVerifier.create(createUseCase.saveBike(bikeDTO))
                .equals(bike);
    }
}