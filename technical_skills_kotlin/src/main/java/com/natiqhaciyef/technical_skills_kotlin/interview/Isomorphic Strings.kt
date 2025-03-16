package com.natiqhaciyef.technical_skills_kotlin.interview

fun isIsomorphic(s: String, t: String): Boolean {
    val hashMap = hashMapOf<Char, Char>()

    if (s.length != t.length)
        return false

    for (index in s.indices) {
//        println("S: ${s[index]}")
//        println("T: ${t[index]}")

        if (hashMap.containsKey(s[index])) {
//            println("Hash: ${hashMap[s[index]]}")

            if (hashMap[s[index]] != t[index]) {
//                println("In")
                return false
            }
        } else {
            if (!hashMap.values.contains(t[index]))
                hashMap[s[index]] = t[index]
            else
                return false
        }

    }

    return true
}

fun main() {
    val s1 = "babc"
    val t1 = "baba"

    println(isIsomorphic(s1, t1))
}