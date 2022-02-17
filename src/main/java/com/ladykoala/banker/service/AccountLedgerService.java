package com.ladykoala.banker.service;

import com.ladykoala.banker.model.ResponseTransferCashDto;
import com.ladykoala.banker.dao.AccountDao;
import com.ladykoala.banker.model.RequestTransferCashDto;
import com.ladykoala.banker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountLedgerService {

    @Value("${bank.name}")
    private String bankName;
    @Value("${bank.account}")
    private String bankAccount;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseTransferCashDto addCredit(RequestTransferCashDto dto)throws Exception{
        float amount = dto.getAmount();
        String account = dto.getAccount();

        AccountDao dao = accountRepository.findByAccount(account);
        if(dao == null){
            throw new Exception("Account not found");
        }
        if(dao.getBalance() < amount){
            throw new Exception("Insufficient Balance");
        }

        float updatedBalance = dao.getBalance() - amount;
        dao.setBalance(updatedBalance);
        accountRepository.save(dao);

        // todo: create corda entry

        // final response
        ResponseTransferCashDto transferdto = new ResponseTransferCashDto();
        transferdto.setAccount(account);
        transferdto.setAmount(amount);
        transferdto.setCreated(new Date());
        return transferdto;
    }

}
