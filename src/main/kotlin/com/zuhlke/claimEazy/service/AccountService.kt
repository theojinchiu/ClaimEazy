package com.zuhlke.claimEazy.service

import com.zuhlke.claimEazy.model.Account
import com.zuhlke.claimEazy.repository.AccountDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {
    var accountDao: AccountDao

    @Autowired
    constructor(accountDao: AccountDao) {
        this.accountDao = accountDao
    }

    fun getAllAccounts(): List<Account> {
        return accountDao.findAll()
    }
}