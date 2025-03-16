package com.natiqhaciyef.technical_skills_kotlin.interview

fun lengthOfLastWord(s: String): Int {
    val trimmedS = s.trimEnd()
    var temp = ""

    for (i in trimmedS.length - 1 downTo 0) {
        if (s[i] != ' ')
            temp += s[i]
        else
            return temp.length
    }

    return temp.length
}

//Example 1:
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.

//Example 2:
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.

//Example 3:
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.

fun main() {
    val s1 = "Hello World"
    val s2 = "   fly me   to   the moon  "
    val s3 = "luffy is still joyboy"

    println(lengthOfLastWord(s1))
    println(lengthOfLastWord(s2))
    println(lengthOfLastWord(s3))
}
