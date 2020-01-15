package com.example.helloworld.service;

import com.example.helloworld.dao.IRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements IRedisService {

    @Autowired
    private IRedisDao redisDao;

    @Override
    public void setKey(String key, String value) {
        redisDao.setKey(key, value);
    }

    @Override
    public String getKey(String key) {
        return redisDao.getKey(key);
    }
}
