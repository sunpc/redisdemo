package com.example.helloworld.controller;

import com.example.helloworld.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private IRedisService redisService;

    @PostMapping("/setkey")
    public String setKey(@RequestBody Map<String, Object> params) {
        String key = (String) params.get("key");
        String value = (String) params.get("value");
        redisService.setKey(key, value);
        return "OK";
    }

    @GetMapping("/getkey/{key}")
    public String getKey(@PathVariable("key") String key) {
        return redisService.getKey(key);
    }

}
