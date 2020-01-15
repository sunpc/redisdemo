package com.example.helloworld.dao;

import com.example.helloworld.entity.AcctOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AcctOwnerDao implements IAcctOwnerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AcctOwner> getAcctOwnerListBySpie(BigInteger spieId, String effcDate) {
        String sql = "SELECT ACCT_OWNER_ID, ACCT_MASTER_ID, QUOTA_AMT " +
                "FROM FMST_O_TD_ACCT_OWNER " +
                "WHERE SELLER_PROF_IE_ID = ? and EFFC_DATE = ? and APPR_STATUS = 'Approved' WITH UR";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, spieId, effcDate);

        List<AcctOwner> acctOwnerList = new ArrayList<>();
        for (Map<String, Object> entry : list) {
            AcctOwner acctOwner = new AcctOwner(new BigInteger(entry.get("ACCT_OWNER_ID").toString()),
                    new BigInteger(entry.get("ACCT_MASTER_ID").toString()),
                    new BigDecimal(entry.get("QUOTA_AMT").toString()));
            acctOwnerList.add(acctOwner);
        }

        return acctOwnerList;
    }
}
