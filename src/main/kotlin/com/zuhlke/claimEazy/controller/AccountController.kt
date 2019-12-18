package com.zuhlke.claimEazy.controller

import com.zuhlke.claimEazy.model.Account
import com.zuhlke.claimEazy.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(path = ["/api/v1/accounts"])
@RestController
class AccountController @Autowired
constructor(private val accountService: AccountService) {

    @GetMapping
    fun getAllAccounts(): List<Account> {
        return accountService.getAllAccounts()
    }
}
