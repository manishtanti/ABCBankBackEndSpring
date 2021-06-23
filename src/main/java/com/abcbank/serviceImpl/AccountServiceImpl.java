package com.abcbank.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.model.Account;
import com.abcbank.repository.AccountRepo;
import com.abcbank.repository.StatementRepo;
import com.abcbank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private StatementRepo statementRepo;

    @Override
    @Transactional
    public Object getAccounts(Long customerId) {
        List<Account> accList = accountRepo.getAccounts(customerId);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Account a : accList) {
            Double averageBalance = statementRepo.getAverageBalance(a.getAccountNumber());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("accountNumber", a.getAccountNumber());
            map.put("accountType", a.getAccountType());
            map.put("accountBalance", a.getAccountBalance());
            map.put("averageBalance",averageBalance);
            list.add(map);
        }
        return list;
    }
}
