package com.example.helloworld.dao;

import com.example.helloworld.entity.AcctOwner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Repository
public class RedisDao implements IRedisDao {

    @Resource(name="redisTemplate")
    private RedisTemplate<String, String> redisTemplateKey;

    @Resource(name="redisTemplate")
    private RedisTemplate<String, AcctOwner> redisTemplateAcctOwner;

    @Override
    public void setKey(String key, String value) {
        redisTemplateKey.opsForValue().set(key, value);
    }

    @Override
    public String getKey(String key) {
        return Objects.requireNonNull(redisTemplateKey.opsForValue().get(key)).toString();
    }

    @Override
    public void setAcctOwnerList(BigInteger spieId, String effcDate, List<AcctOwner> list) {
        String key = "SPIE" + spieId + "EFFC" + effcDate;
        redisTemplateAcctOwner.opsForList().rightPushAll(key, list);
    }

    @Override
    public List<AcctOwner> getAcctOwnerList(BigInteger spieId, String effcDate) {
        String key = "SPIE" + spieId + "EFFC" + effcDate;
        return redisTemplateAcctOwner.opsForList().range(key, 0, -1);
    }
}
