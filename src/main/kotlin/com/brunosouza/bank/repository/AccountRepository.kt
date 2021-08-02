package com.brunosouza.bank.repository

import com.brunosouza.bank.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {
}