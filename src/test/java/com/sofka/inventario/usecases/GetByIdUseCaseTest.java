package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.repositories.BikeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetByIdUseCaseTest {
    @SpyBean
    GetByIdUseCase getByIdUseCase;

    @Mock
    BikeRepository bikeRepository;

    @Test
    void apply() {
        String id = "idbike";
        Bike bike = new Bike("idBike", "nameBike",500L,true,8L,200L,"urlImage",true,2000000D);

        Mockito.when(bikeRepository.findById(id)).thenReturn(Mono.just(bike));


        StepVerifier.create(getByIdUseCase.apply("idBike"))
                .expectNext(bike);

    }
}