package com.techoral.redis.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public record User(
    @Id
    String id,
    String name,
    String role
) implements Serializable{
}