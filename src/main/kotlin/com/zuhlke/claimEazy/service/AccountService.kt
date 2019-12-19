package com.zuhlke.claimEazy.service

import com.zuhlke.claimEazy.model.Account
import com.zuhlke.claimEazy.repository.AccountDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

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

    fun getAccountById(id: String) : Optional<Account> {
        return accountDao.findById(id)
    }

    fun createAccount(name: String, password: String) : Account  {
        var account = Account(UUID.randomUUID().toString(), name, password)
        accountDao.save(account)
        return account
    }
}