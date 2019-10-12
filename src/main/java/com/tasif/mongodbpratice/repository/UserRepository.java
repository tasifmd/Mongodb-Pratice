package com.tasif.mongodbpratice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasif.mongodbpratice.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
