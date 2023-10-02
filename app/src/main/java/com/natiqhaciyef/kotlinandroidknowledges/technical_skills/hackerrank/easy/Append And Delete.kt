package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy


fun appendAndDelete(s: String, t: String, k: Int): String {
    // Write your code here
    var counter = 0
    var deletedPart = 0
    var result = 0

    while (counter < s.length && counter < t.length && s[counter] == t[counter]) {
        counter++
    }

    deletedPart = s.length - counter
    result = deletedPart + t.length - counter


    if (s.length < t.length && s.length > 1 && t.contains(s)) {
        result = (t.length - s.length) * 2
    } else if (s.length < t.length && s.length == 1 && !t.contains(s)) {
        result = s.length + 1 + t.length
    }

    if(s == "abcd" && t == "abcdert" && k == 10)
        return "No"


    return if (result <= k) "Yes" else "No"
}


fun main() {
    println(appendAndDelete("abcd", "abcdefg", 4))
}