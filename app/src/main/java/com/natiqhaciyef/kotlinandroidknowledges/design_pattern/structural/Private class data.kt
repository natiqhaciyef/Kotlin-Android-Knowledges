package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural

class Account(accountNumber: Int, initialBalance: Double) {
    private class Data(val accountNumber: Int, var balance: Double)

    private val data: Data

    init {
        data = Data(accountNumber, initialBalance)
    }

    companion object {
        fun createFromDatabase(accountData: Map<String, Any>): Account? {
            val accountNumber = accountData["accountNumber"] as? Int ?: return null
            val balance = accountData["balance"] as? Double ?: return null
            return Account(accountNumber, balance)
        }
    }

    fun getAccountNumber(): Int {
        return data.accountNumber
    }

    fun getBalance(): Double {
        return data.balance
    }

    fun deposit(amount: Double) {
        data.balance += amount
    }

    fun withdraw(amount: Double) {
        if (amount > data.balance) {
            throw InsufficientFundsException()
        }
        data.balance -= amount
    }
}

class InsufficientFundsException : Exception()

fun main() {
    val account = Account(1, 200.0)
    account.getAccountNumber()
}
