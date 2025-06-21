package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.generics


fun priceCalculator(salary: Double, discount: Double) =
    salary * discount/100


// this called partial function
fun <T1, T2, R>((T1, T2) -> R).replaceSalary(salary: T1): (T2) -> R =
    { t2 -> this.invoke(salary, t2) }


fun main() {

    val calculate = ::priceCalculator.replaceSalary(100.0)
    calculate.invoke(200.0)
}