package com.zuhlke.claimEazy.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.zuhlke.claimEazy.service.AccountService
import org.springframework.stereotype.Component

@Component
class AccountQueryResolver(private val accountService :AccountService) : GraphQLQueryResolver {
    fun getAccountById(id: String) = accountService.getAccountById(id)
}