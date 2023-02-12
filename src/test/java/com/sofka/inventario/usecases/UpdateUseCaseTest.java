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
class UpdateUseCaseTest {

    @SpyBean
    private UpdateUseCase updateUseCase;
    @Mock
    private BikeRepository bikeRepository;

    @Test
    void updateBike() {

        Bike bikeToUpdate = new Bike("idBike", "nameBike", 500L, true, 8L, 200L, "urlImage", true, 2000000D);


        Bike bike = Mockito.mock(Bike.class);
        Mockito.when(updateUseCase.updateBike(bike)).thenReturn(Mono.just("idBike"));

        StepVerifier.create(updateUseCase.updateBike(bikeToUpdate))
                .expectNextMatches(id ->{
                    assert id.equals("idBike");
                    return true;
        }).verifyComplete();
    }
}