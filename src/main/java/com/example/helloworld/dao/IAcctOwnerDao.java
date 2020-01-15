package com.example.helloworld.dao;

import com.example.helloworld.entity.AcctOwner;

import java.math.BigInteger;
import java.util.List;

public interface IAcctOwnerDao {

    List<AcctOwner> getAcctOwnerListBySpie(BigInteger spieId, String effcDate);
}
