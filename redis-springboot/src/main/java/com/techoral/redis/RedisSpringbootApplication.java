package com.techoral.redis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * www.techoral.com
 *
 */
@SpringBootApplication
@RestController
public class RedisSpringbootApplication  
{
    public static void main( String[] args )
    {
         SpringApplication.run(RedisSpringbootApplication.class, args);
    }

    @GetMapping("/")
    public String getGeeting(){
        return "CloubBurst Services - hosted on GitPOD ";
    }

}
