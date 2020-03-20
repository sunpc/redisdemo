package com.example.helloworld.controller;

import com.example.helloworld.entity.AcctOwner;
import com.example.helloworld.service.IAcctOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/html")
public class HtmlController {

    @Autowired
    private IAcctOwnerService acctOwnerService;

    @GetMapping("/getAcctOwner/{effcDate}/{spieId}")
    public String getAcctOwner(Model model,
                                        @PathVariable("effcDate") String effcDate,
                                        @PathVariable("spieId") BigInteger spieId) {
        long t1=System.currentTimeMillis();
        List<AcctOwner> list = acctOwnerService.getAcctOwnerListBySpie(spieId, effcDate);
        long t2=System.currentTimeMillis();

        model.addAttribute("effcDate", effcDate);
        model.addAttribute("spieId", spieId);
        model.addAttribute("list", list);
        model.addAttribute("time", t2 - t1);
        return "acctOwnerList";
    }

}
