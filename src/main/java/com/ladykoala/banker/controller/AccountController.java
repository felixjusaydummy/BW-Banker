package com.ladykoala.banker.controller;
import com.ladykoala.banker.model.*;
import com.ladykoala.banker.service.AccountService;
import com.ladykoala.banker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/linkaccount", method = RequestMethod.POST)
    public ResponseAccountBalanceDto linkAccount(@RequestBody RequestAccountDto request) throws Exception {
        return accountService.linkAccount(request.getUsername(), request.getPassword());
    }

    @RequestMapping(value = "/balance", method = RequestMethod.POST)
    public ResponseAccountBalanceDto getBalance(@RequestBody RequestBalanceDto request) throws Exception {
        return accountService.getBalance(request.getAccount());
    }

}