package com.example.helloworld.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AcctOwner implements Serializable {

    private static final long serialVersionUID = 4359709211352400087L;

    private BigInteger acctOwnerId;
    private BigInteger acctMasterId;
    private BigDecimal quotaAmt;

    public AcctOwner(BigInteger acctOwnerId, BigInteger acctMasterId, BigDecimal quotaAmt) {
        this.acctOwnerId = acctOwnerId;
        this.acctMasterId = acctMasterId;
        this.quotaAmt = quotaAmt;
    }

    public void setAcctMasterId(BigInteger acctMasterId) {
        this.acctMasterId = acctMasterId;
    }

    public void setAcctOwnerId(BigInteger acctOwnerId) {
        this.acctOwnerId = acctOwnerId;
    }

    public void setQuotaAmt(BigDecimal quotaAmt) {
        this.quotaAmt = quotaAmt;
    }

    public BigInteger getAcctMasterId() {
        return acctMasterId;
    }

    public BigInteger getAcctOwnerId() {
        return acctOwnerId;
    }

    public BigDecimal getQuotaAmt() {
        return quotaAmt;
    }
}
