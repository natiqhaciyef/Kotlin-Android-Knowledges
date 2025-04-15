package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

class FenwickTree(private val size: Int) {
    private val tree = IntArray(size + 1) { 0 }

    fun update(index: Int, value: Int) {
        var i = index
        while (i <= size) {
            tree[i] += value
            i += i and -i
        }
    }

    fun query(index: Int): Int {
        var sum = 0
        var i = index
        while (i > 0) {
            sum += tree[i]
            i -= i and -i
        }
        return sum
    }

    fun rangeQuery(l: Int, r: Int): Int {
        return query(r) - query(l - 1)
    }
}

// Example usage
fun main() {
    val ft = FenwickTree(10)
    ft.update(3, 5)   // Add 5 at index 3
    ft.update(1, 2)   // Add 2 at index 1
    ft.update(7, 3)   // Add 3 at index 7

    println("Sum of first 3 elements: ${ft.query(3)}") // Output: 7
    println("Sum from index 2 to 7: ${ft.rangeQuery(2, 7)}") // Output: 5
}
