package com.brunosouza.bank.controller

import com.brunosouza.bank.model.Account
import com.brunosouza.bank.repository.AccountRepository
import com.brunosouza.bank.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("accounts")
class AccountController(private val accountService: AccountService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody account: Account): Account = accountService.create(account)

    @GetMapping
    fun getAll(): List<Account> = accountService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Account> =
        accountService.getById(id).map{
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody account: Account): ResponseEntity<Account> =
        accountService.update(id, account).map{
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        accountService.delete(id)
        return ResponseEntity<Void>(HttpStatus.NO_CONTENT)
    }
}