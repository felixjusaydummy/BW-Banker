package com.ladykoala.banker.controller;
import com.ladykoala.banker.model.RequestTransferCashDto;
import com.ladykoala.banker.model.ResponseTransferCashDto;
import com.ladykoala.banker.service.AccountLedgerService;
import com.ladykoala.banker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class AccountLedgerController {

    @Autowired
    AccountLedgerService accountLedgerService;

    @RequestMapping(value = "/transferCash", method = RequestMethod.POST)
    public ResponseTransferCashDto transferCash(@RequestBody RequestTransferCashDto request) throws Exception {
        return accountLedgerService.addCredit(request);
    }

    @RequestMapping(value = "/applyLoan", method = RequestMethod.POST)
    public ResponseTransferCashDto applyLoan(@RequestBody RequestTransferCashDto request) throws Exception {
        return accountLedgerService.addCredit(request);
    }

}