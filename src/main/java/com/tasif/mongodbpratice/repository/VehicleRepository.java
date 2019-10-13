package com.tasif.mongodbpratice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasif.mongodbpratice.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

}
