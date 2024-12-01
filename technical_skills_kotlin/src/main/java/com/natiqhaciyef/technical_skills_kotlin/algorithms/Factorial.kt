package com.natiqhaciyef.technical_skills_kotlin.algorithms


// All examples return the factorial of given number

/** Common Factorial function
 *
 * @params      integer which is for find factorial
 * @returns     integer calculated value
 * @exception   number < 0
 *
 * @runtime     O(n) => n * (t1 + t2 + p2) + (p1 + p3 + t1 + t2)
 * */
fun commonFactorial(num: Int): Int {
    // takes space for holding number   => p1
    var result = 1

    // it checks i is grater than 1     => t2
    // Also lower or equal than num     => t1
    for (i in num downTo 1) {

        // calculates number result = result * i    => p2
        result *= i
    }

    // returns number   => p3
    return result
}


/** Better Factorial function
 *
 * @params      integer which is for find factorial
 * @returns     integer calculated value
 * @exception   number < 0
 *
 * @runtime     O(n) => n * (t1 + a1 + p2)
 * */
fun betterFactorial(num: Int): Int {
    // checks num > 1   =>  t1
    if (num > 1)
    // calculates and returns   => a1 + p2
        return num * betterFactorial(num - 1)

    // returns   => p2
    return 1
}

fun main() {
    println(commonFactorial(0))
    println(betterFactorial(0))
}