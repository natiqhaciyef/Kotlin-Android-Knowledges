package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun isPalindrome(s: String): Boolean {
    var customS = ""

    for (c in s) {
        if (c.isLetter() || c.isDigit())
            customS += c
    }

    customS = customS.lowercase()
    for (index in 0 until customS.length / 2) {
        if (customS[index] != customS[customS.length - 1 - index])
            return false
    }

    return true
}

//Example 1:
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.

//Example 2:
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.

//Example 3:
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.

fun main() {
    val s1 = "A man, a plan, a canal: Panama"
    val s2 = "race a car"
    val s3 = " "
    val s4 = "0P"
    println(isPalindrome(s1))
    println(isPalindrome(s2))
    println(isPalindrome(s3))
    println(isPalindrome(s4))
}