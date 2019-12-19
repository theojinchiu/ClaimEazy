package com.zuhlke.claimEazy.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.zuhlke.claimEazy.service.AccountService
import org.springframework.stereotype.Component

@Component
class QueryResolver(private val accountService: AccountService) : GraphQLQueryResolver {
    fun version() = "1.0.0"
}