package com.example.helloworld.controller;

import com.example.helloworld.entity.AcctOwner;
import com.example.helloworld.service.IAcctOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private IAcctOwnerService acctOwnerService;

    @GetMapping("/getAcctOwner/{effcDate}/{spieId}")
    public List<AcctOwner> getAcctOwner(@PathVariable("effcDate") String effcDate,
                                  @PathVariable("spieId") BigInteger spieId) {
        return acctOwnerService.getAcctOwnerListBySpie(spieId, effcDate);
    }

    @GetMapping("/getAcctOwnerDB2/{effcDate}/{spieId}")
    public List<AcctOwner> getAcctOwnerDB2(@PathVariable("effcDate") String effcDate,
                                  @PathVariable("spieId") BigInteger spieId) {
        return acctOwnerService.getAcctOwnerListBySpieFromDB2(spieId, effcDate);
    }

}
