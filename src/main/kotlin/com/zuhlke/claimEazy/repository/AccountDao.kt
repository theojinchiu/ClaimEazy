package com.zuhlke.claimEazy.repository

import com.zuhlke.claimEazy.model.Account
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountDao : MongoRepository<Account, String> {
}