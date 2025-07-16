package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

private fun isValid(sub: String): Boolean {
    val s = sub.toMutableList().map { it.toString() }.toMutableList()
    if (s.size <= 1)
        return false

    while (s.isNotEmpty()) {
        if (s.contains("(")) {
            if (s.contains(")") && s.indexOf(")") > s.indexOf("(") && (s.indexOf("(") - s.indexOf(")")) % 2 != 0) {
                s.removeAt(s.indexOf("("))
                s.removeAt(s.indexOf(")"))
                println(s)
            } else
                return false
        }

        if (s.contains("{")) {
            if (s.contains("}") && s.indexOf("}") > s.indexOf("{") && (s.indexOf("{") - s.indexOf("}")) % 2 != 0) {
                s.removeAt(s.indexOf("{"))
                s.removeAt(s.indexOf("}"))
                println(s)
            } else
                return false
        }

        if (s.contains("[")) {
            if (s.contains("]") && s.indexOf("]") > s.indexOf("[") && (s.indexOf("[") - s.indexOf("]")) % 2 != 0) {
                s.removeAt(s.indexOf("["))
                s.removeAt(s.indexOf("]"))

                println(s)
            } else
                return false
        }
    }
    return true
}


fun isValidFast(sub: String): Boolean {
    val stack = mutableListOf<Char>()

    for (char in sub) {
        when (char) {
            '(', '{', '[' -> stack.add(char)
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
        }
    }

    return stack.isEmpty()
}

fun main() {
    println(isValid("()[]{}"))
    println(isValid("([)]{}"))
    println(isValid("(){}}{"))
}