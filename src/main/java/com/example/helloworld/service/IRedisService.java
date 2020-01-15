package com.example.helloworld.service;

public interface IRedisService {

    void setKey(String key, String value);

    String getKey(String key);

}
