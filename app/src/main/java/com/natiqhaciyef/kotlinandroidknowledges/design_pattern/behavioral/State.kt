package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface VendingMachineState {
    var selectedProduct: String?
    fun selectProduct(product: String): String
    fun insertMoney(amount: Int): String
    fun dispenseProduct(): String
}

class VendingMachine(private var state: VendingMachineState = NoSelectionState()) {
    fun setState(newState: VendingMachineState) {
        if (state.selectedProduct != null)
            state = newState
    }

    fun selectProduct(product: String): String =
        state.selectProduct(product)

    fun insertMoney(amount: Int): String =
        state.insertMoney(amount)

    fun dispenseProduct(): String =
        state.dispenseProduct()
}


class NoSelectionState : VendingMachineState {
    override var selectedProduct: String? = null  // Store selected product

    override fun selectProduct(product: String): String {
        selectedProduct = product
        return "Please insert money first."
    }

    override fun insertMoney(amount: Int): String =
        "Selected product: $selectedProduct"

    override fun dispenseProduct(): String =
        "Please select a product first."
}

class HasMoneyState : VendingMachineState {
    override var selectedProduct: String? = null  // Store selected product

    override fun selectProduct(product: String): String {
        selectedProduct = product
        return "Product dispensed."
    }

    override fun insertMoney(amount: Int): String =
        "You already inserted money."

    override fun dispenseProduct(): String =
        "Dispensing $selectedProduct..."
}

fun main() {
    val machine = VendingMachine()

    machine.setState(HasMoneyState())
    println(machine.selectProduct("Soda"))
    println(machine.insertMoney(100))
    println(machine.dispenseProduct())
}


