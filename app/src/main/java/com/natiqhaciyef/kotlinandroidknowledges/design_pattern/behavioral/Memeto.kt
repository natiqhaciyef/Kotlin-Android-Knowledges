package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface Memento {
    // Usually , as the Originator knows how to interact with it
}

class BankAccountMemento(val balance: Int) : Memento {
    // Encapsulates the saved state
}


class BankAccount(private var balance: Int) {
    fun deposit(amount: Int) {
        balance += amount
        println("Deposited $amount, new balance: $balance")
    }

    fun withdraw(amount: Int) {
        if (balance >= amount) {
            balance -= amount
            println("Withdrew $amount, new balance: $balance")
        } else {
            println("Insufficient funds")
        }
    }

    fun saveStateToMemento(): Memento {
        return BankAccountMemento(balance)
    }

    fun restoreStateFromMemento(memento: Memento) {
        if (memento is BankAccountMemento) {
            balance = memento.balance
            println("State restored, balance: $balance")
        } else {
            println("Invalid memento")
        }
    }
}

fun main() {
    val account = BankAccount(100)
    account.deposit(50)

    val savedState = account.saveStateToMemento()
    account.withdraw(120)
    account.restoreStateFromMemento(savedState)
}

