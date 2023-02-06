package com.sofka.inventario.repositories;

import com.sofka.inventario.collections.Bike;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BikeRepository extends ReactiveMongoRepository<Bike, String>{
}
