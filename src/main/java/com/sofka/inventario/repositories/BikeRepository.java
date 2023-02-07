package com.sofka.inventario.repositories;

import com.sofka.inventario.collections.Bike;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BikeRepository extends ReactiveCrudRepository<Bike, String> {
    Flux<Bike> findAllByIdNotNullOrderByIdAsc(final Pageable pageable);
}
