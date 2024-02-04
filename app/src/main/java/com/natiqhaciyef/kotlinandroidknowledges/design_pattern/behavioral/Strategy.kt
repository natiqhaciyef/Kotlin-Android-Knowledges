package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral


interface SortingStrategy { fun sort(numbers: IntArray): IntArray }

class BubbleSort : SortingStrategy {
    override fun sort(numbers: IntArray): IntArray { return numbers }
}

class QuickSort : SortingStrategy {
    override fun sort(numbers: IntArray): IntArray { return numbers }
}

class Sorter(private var strategy: SortingStrategy) {
    fun setStrategy(newStrategy: SortingStrategy) { strategy = newStrategy }

    fun sortNumbers(numbers: IntArray): IntArray { return strategy.sort(numbers) }
}

fun main() {
    val numbers = intArrayOf(4, 2, 7, 1, 3)
    val sorter = Sorter(BubbleSort())

    println("Unsorted: ${numbers.contentToString()}")

    val sortedNumbers = sorter.sortNumbers(numbers)
    println("Sorted (Bubble Sort): ${sortedNumbers.contentToString()}")

    sorter.setStrategy(QuickSort())
    val quickSortedNumbers = sorter.sortNumbers(numbers)
    println("Sorted (Quick Sort): ${quickSortedNumbers.contentToString()}")
}

