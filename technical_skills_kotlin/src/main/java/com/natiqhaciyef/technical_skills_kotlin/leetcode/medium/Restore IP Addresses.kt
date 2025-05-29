package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

private val result = mutableListOf<String>()
fun restoreIpAddresses(s: String): List<String> {
    // Topics: String, Backtracking

    backtrack(s, "")
    println(result)
    return result
}

fun backtrack(remain: String, valid: String) {
    // if valid contains over 3 dots
    if (valid.count { it == '.' } > 3)
        return

    // if remain is empty
    if (remain.isEmpty()) {
        if (valid.count { it == '.' } == 3)
            result.add(valid)

        return
    }

    // if remain start with 0
    var current = valid
    if (remain[0] == '0') {
        if (valid.isNotEmpty())
            current += "."

        current += "0"
        val changed = remain.substring(1..remain.lastIndex)
        backtrack(changed, current)
        return
    }

    var subs = ""
    for (i in remain.indices) {
        subs += remain[i]
//        println(subs)

        if (subs.toInt() <= 255) {
            val changed = if (valid.isEmpty()) subs else "$valid.$subs"
            backtrack(remain.substring(i + 1 .. remain.lastIndex), changed)
        }else{
            break
        }
    }
}

fun main() {
    restoreIpAddresses("25525511135")
    result.clear()
    restoreIpAddresses("0000")
    result.clear()
    restoreIpAddresses("101023")
}