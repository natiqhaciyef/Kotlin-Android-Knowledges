package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural

import java.util.UUID

interface Waiter {
    fun takeOrder()
    fun sendOrderToKitchen()
    fun serveFood()
    fun getBill(orderId: String)
}

interface Kitchen {
    fun prepareFood()
    fun callWaiter()
    fun washesDishes()
}

class WaiterImpl : Waiter {
    override fun takeOrder() {
        println("Taking order from customer")
    }

    override fun sendOrderToKitchen() {
        println("Sending order to kitchen")
    }

    override fun serveFood() {
        println("Serving food to customer")
    }

    override fun getBill(orderId: String) {
        println("Getting bill from customer: $orderId")
    }
}

class KitchenImpl : Kitchen {
    override fun prepareFood() {
        println("Preparing food")
    }

    override fun callWaiter() {
        println("Calling waiter")
    }

    override fun washesDishes() {
        println("Washing dishes")
    }
}

class OrderFood {
    private val waiter: Waiter = WaiterImpl()
    private val kitchen: Kitchen = KitchenImpl()

    fun orderFood(orderId: String) {
        waiter.takeOrder()
        waiter.sendOrderToKitchen()
        kitchen.prepareFood()
        kitchen.callWaiter()
        waiter.serveFood()
        waiter.getBill(orderId = orderId)
        kitchen.washesDishes()
    }
}

class Customer {
    private val orderFood = OrderFood()

    fun orderFood(str: String = "ORD${UUID.randomUUID()}") {
        orderFood.orderFood(str)
    }
}

fun main() {
    val customer1 = Customer()
    customer1.orderFood()
}

