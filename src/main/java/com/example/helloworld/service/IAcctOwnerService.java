package com.example.helloworld.service;

import com.example.helloworld.entity.AcctOwner;

import java.math.BigInteger;
import java.util.List;

public interface IAcctOwnerService {

    List<AcctOwner> getAcctOwnerListBySpie(BigInteger spieId, String effcDate);

    List<AcctOwner> getAcctOwnerListBySpieFromDB2(BigInteger spieId, String effcDate);

}
