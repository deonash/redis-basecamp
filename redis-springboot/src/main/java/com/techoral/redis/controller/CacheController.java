package com.techoral.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.time.Duration;
import java.io.Serializable;


@RestController
@RequestMapping("/user")
public class CacheController
{

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public record UserDTO(String id, String name, String role) implements Serializable {};



    @GetMapping("/{id}")
    public Object getUser(@PathVariable String id)
    {
        String key = "user:"+id;

        ValueOperations<String,Object> ops = redisTemplate.opsForValue();

        UserDTO cached = (UserDTO)ops.get(key);

        if(cached != null)
        {
            return Map.of("cached",true,"data",cached);
        }

        // simulated DB/user fetch

        // Map<String,Object> user = Map.of(
        //     "id",id,
        //     "name","User "+id,
        //     "role","reader"
        // );

        UserDTO user = new UserDTO(id,"user "+id,"reader");

        ops.set(key, user, Duration.ofMinutes(1));
        return Map.of("cached",false,"data",user);

    }
}