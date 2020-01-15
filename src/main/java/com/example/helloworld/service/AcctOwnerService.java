package com.example.helloworld.service;

import com.example.helloworld.dao.IAcctOwnerDao;
import com.example.helloworld.dao.IRedisDao;
import com.example.helloworld.entity.AcctOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class AcctOwnerService implements IAcctOwnerService {

    @Autowired
    private IAcctOwnerDao acctOwnerDao;

    @Autowired
    private IRedisDao redisDao;

    @Override
    public List<AcctOwner> getAcctOwnerListBySpie(BigInteger spieId, String effcDate) {
        List<AcctOwner> list = redisDao.getAcctOwnerList(spieId, effcDate);

        if (list.isEmpty()) {
            list = acctOwnerDao.getAcctOwnerListBySpie(spieId, effcDate);
            redisDao.setAcctOwnerList(spieId, effcDate, list);
        }

        return list;
    }

    @Override
    public List<AcctOwner> getAcctOwnerListBySpieFromDB2(BigInteger spieId, String effcDate) {
        return acctOwnerDao.getAcctOwnerListBySpie(spieId, effcDate);
    }
}
