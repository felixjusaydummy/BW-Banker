package com.ladykoala.banker.service;

import com.ladykoala.banker.dao.AccountDao;
import com.ladykoala.banker.repository.AccountRepository;
import com.ladykoala.banker.model.ResponseAccountBalanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Value("${bank.name}")
    private String bankName;
    @Value("${bank.account}")
    private String bankAccount;

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private AccountServiceCorda accountServiceCorda;

    public ResponseAccountBalanceDto linkAccount(String username, String password){
        AccountDao dao = accountRepository.findByUnameAndPword(username, password);
        ResponseAccountBalanceDto dto = new ResponseAccountBalanceDto();
        dto.setAccount(dao.getAccount());
        if(dao != null){
            dto.setBalance(dao.getBalance());
            dto.setBankAccount(bankAccount);
            dto.setBankName(bankName);

            // corda
            String flowId = accountServiceCorda.linkKYCtoCorda(dao);
            if(flowId!=null) {
                dao.setCordakycid(flowId);
                accountRepository.save(dao);
                dto.setCordaFlowId(flowId);
            }
        }
        return dto;
    }

    public ResponseAccountBalanceDto getBalance(String account){
        AccountDao dao = accountRepository.findByAccount(account);
        ResponseAccountBalanceDto dto = new ResponseAccountBalanceDto();
        if(dao != null){
            dto.setAccount(dao.getAccount());
            dto.setBalance(dao.getBalance());
            dto.setBankAccount(bankAccount);
            dto.setBankName(bankName);
        }
        return dto;
    }


}
