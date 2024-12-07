package com.natiqhaciyef.technical_skills_kotlin.leetcode

fun solution(s: String): Boolean {
    if (s.contains(" ") || s.length < 6)
        return false

    var hasDigit = false
    var hasSpecial = false
    var hasUpper = false
    var hasLetter = false

    for (element in s) {

        when {
            element.isDigit() -> hasDigit = true
            element.isLetter() && element.isLowerCase() -> hasLetter = true
            element.isLetter() && element.isUpperCase() -> {
                hasUpper = true
            }

            !element.isLetter() && !element.isDigit() -> hasSpecial = true
        }


    }

    return hasDigit && hasSpecial && hasUpper && hasLetter
}



/*
You are given a string S made of lowercase letters ('a' - 'z') and question marks (?). You must replace each question mark in S with any lowercase letter. You are also given an integer K. After replacing the question marks, you may replace at most K characters in S with any lowercase letter.

Write a function:
fun solution(S: String, K: Int): String
That, given a string S of length N and an integer K, returns any palindrome that can be obtained by performing the operations described above. If it is not possible to obtain a palindrome from S, the function should return the string "NO".
A palindrome is a string that reads the same both forwards and backwards. Some examples of palindromes are: "kayak", "abba", "zaz".

Examples:
1. Given S = "?ab??a" and K = 0, the function should return "aabbaa".
2. Given S = "guz?za" and K = 1, the function should return "NO".
3. Given S = "?gad?bc?d?g?" and K = 2, the function may return "agadcbcdcba". It may also return "fgddcbcbddgf", among other possible answers. The function is supposed to return only one of the possible answers.

Assume that:
N is an integer within the range [1..1,000];
K is an integer within the range [0..N];
string S is made only of lowercase English letters ('a' - 'z') and/or ? characters.

Notes:
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
* */
fun solution(s: String, k: Int): String {
    val n = s.length
    val chars = s.toCharArray()
    var changesRequired = 0

    for (i in 0 until n / 2) {
        val j = n - i - 1
        if (chars[i] == '?' && chars[j] == '?') {
            chars[i] = 'a'
            chars[j] = 'a'
        } else if (chars[i] == '?') {
            chars[i] = chars[j]
        } else if (chars[j] == '?') {
            chars[j] = chars[i]
        } else if (chars[i] != chars[j]) {
            changesRequired++
            if (chars[i] < chars[j]) {
                chars[j] = chars[i]
            } else {
                chars[i] = chars[j]
            }
        }
    }

    if (changesRequired > k) return "NO"

    var remainingChanges = k - changesRequired
    for (i in 0 until n / 2) {
        if (remainingChanges == 0) break

        val j = n - i - 1
        if (chars[i] != 'z') {
            if (chars[i] != chars[j] || chars[i] != 'z') {
                if (remainingChanges >= 2 || (remainingChanges == 1 && chars[i] != chars[j])) {
                    if (chars[i] != 'z') {
                        chars[i] = 'z'
                        remainingChanges--
                    }
                    if (chars[j] != 'z') {
                        chars[j] = 'z'
                        remainingChanges--
                    }
                }
            }
        }
    }

    if (n % 2 == 1 && remainingChanges > 0) {
        chars[n / 2] = 'z'
    }

    return String(chars)
}
