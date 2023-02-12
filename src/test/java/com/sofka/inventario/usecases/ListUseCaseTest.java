package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.repositories.BikeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ListUseCaseTest {
    @SpyBean
    ListUseCase listUseCase;

    @Mock
    BikeRepository bikeRepository;

    @Test
    void listAllBikes() {

        Bike bike = new Bike("idBike", "nameBike", 500L, true, 8L, 200L, "urlImage", true, 2000000D);


        Mockito.when(bikeRepository.findAll()).thenReturn(Flux.just(bike));

        StepVerifier.create(listUseCase.listAllBikes()).expectNextMatches(bike1 -> {
                            assert bike1.getId().equals(bike.getId());
                            return true;
                        }

                );




    }
}