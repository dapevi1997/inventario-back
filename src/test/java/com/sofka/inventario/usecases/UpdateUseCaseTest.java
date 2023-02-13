package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.repositories.BikeRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
class UpdateUseCaseTest {

    @SpyBean
    private UpdateUseCase updateUseCase;
    @Mock
    private BikeRepository bikeRepository;

    @Test
    void updateBike() {

        Bike bikeToUpdate = new Bike("idBike", "nameBike", 500L, true, 8L, 200L, "urlImage", true, 2000000D);


        Bike bike = Mockito.mock(Bike.class);
        Mockito.when(bikeRepository.save(bike)).thenReturn(Mono.just(bikeToUpdate));

        StepVerifier.create(updateUseCase.updateBike(bikeToUpdate))
                .expectNextMatches(id ->{
                    log.info(id);
                    assert id.equals(bikeToUpdate.getId());
                    return true;
        });
    }
}