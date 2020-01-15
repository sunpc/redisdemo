package com.example.helloworld.dao;

import com.example.helloworld.entity.AcctOwner;

import java.math.BigInteger;
import java.util.List;

public interface IRedisDao {

    void setKey(String key, String value);

    String getKey(String key);

    void setAcctOwnerList(BigInteger spieId, String effcDate, List<AcctOwner> list);

    List<AcctOwner> getAcctOwnerList(BigInteger spieId, String effcDate);
}
