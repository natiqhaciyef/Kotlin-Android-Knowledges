package com.natiqhaciyef.technical_skills_kotlin.interview


//Example 1:
//Input: s = "abc", t = "ahbgdc"
//Output: true

//Example 2:
//Input: s = "axc", t = "ahbgdc"
//Output: false


fun isSubsequence(s: String, t: String): Boolean {
    var index = 0
    var parIndex = 0
    while (index < s.length && parIndex < t.length) {
        if (s[index] == t[parIndex]) {
            index += 1
        }
        parIndex += 1
    }

    return index == s.length
}