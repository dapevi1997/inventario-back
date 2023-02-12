package com.sofka.inventario.usecases;

import com.sofka.inventario.collections.Bike;
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
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeleteUseCaseTest {

    @SpyBean
    private DeleteUseCase deleteUseCase;


    @Mock
    private BikeRepository bikeRepository;

    @Test
    void apply() {
        String id = "id";

        Mockito.when(bikeRepository.deleteById(id)).thenReturn(Mono.empty());

        StepVerifier.create(deleteUseCase.apply(id))
                .expectNext()
                .verifyComplete();

    }
}