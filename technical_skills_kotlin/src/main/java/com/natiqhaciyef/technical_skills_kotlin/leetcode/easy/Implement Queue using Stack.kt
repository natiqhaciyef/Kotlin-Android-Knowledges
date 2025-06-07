package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

// Not direct using stack but logic is stack and we creating reversed stack
class MyQueue() {
    private val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addLast(x)
    }

    fun pop(): Int {
        return if(empty()) -1 else stack.removeFirst()
    }

    fun peek(): Int {
        return if(empty()) -1 else stack.first()
    }

    fun empty(): Boolean {
        return stack.size == 0
    }

}