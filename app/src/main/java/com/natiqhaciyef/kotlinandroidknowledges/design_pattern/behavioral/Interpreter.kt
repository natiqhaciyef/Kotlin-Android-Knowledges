package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface Expression { fun interpret(context: Map<String, Int>): Int }

class NumberExpression(val number: Int) : Expression {
    override fun interpret(context: Map<String, Int>): Int = number
}

class PlusExpression(val left: Expression, val right: Expression) : Expression {
    override fun interpret(context: Map<String, Int>): Int =
        left.interpret(context) + right.interpret(context)
}

class MinusExpression(val left: Expression, val right: Expression) : Expression {
    override fun interpret(context: Map<String, Int>): Int =
        left.interpret(context) - right.interpret(context)
}

class VariableExpression(val name: String) : Expression {
    override fun interpret(context: Map<String, Int>): Int = context[name] ?: 0
}

fun main() {
    val expression = MinusExpression(
        PlusExpression(NumberExpression(3), VariableExpression("x")),
        NumberExpression(2)
    )

    val context = mapOf("x" to 5)
    val result = expression.interpret(context)
    println("Result: $result") // Output: 6
}

