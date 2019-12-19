package com.zuhlke.claimEazy.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Account")
data class Account(@Id val id: String, val password: String, val name: String)