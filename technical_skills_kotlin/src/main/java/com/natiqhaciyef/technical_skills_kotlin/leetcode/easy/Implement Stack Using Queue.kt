package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

class MyStack {
    private val list = mutableListOf<Int>()

    fun push(x: Int) {
        list.add(x)
    }

    fun pop(): Int {
        return if(list.size > 0){
            val result = list[list.size-1]
            list.removeAt(list.size-1)
            result
        }else
            -1
    }

    fun top(): Int {
        val result = if(list.size > 0)
            list[list.size-1]
        else
            -1
        return result
    }

    fun empty(): Boolean {
        return list.isEmpty()
    }

}