package com.zuhlke.claimEazy.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.zuhlke.claimEazy.service.AccountService
import org.springframework.stereotype.Component

@Component
class AccountMutationResolver(private val accountService : AccountService) : GraphQLMutationResolver {
    fun createAccount(name: String, password: String)  = accountService.createAccount(name, password)

}