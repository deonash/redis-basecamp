package com.techoral.redis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techoral.redis.model.User;

public interface UserRepository extends MongoRepository<User,String>{

    
} 