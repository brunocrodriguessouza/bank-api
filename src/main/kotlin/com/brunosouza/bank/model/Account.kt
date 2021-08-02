package com.brunosouza.bank.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Account(

    @Id
    @GeneratedValue
    var id: Long? = null,
    val name: String,
    val document: String,
    val phone: String
)
