package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.medium


fun lengthOfLongestSubstringScratch(s: String): Int {
    val result = mutableListOf<Int>()


    for (i in s.indices){
        for (j in i until s.length){
            var content = s.substring(i .. j)
            for (k in s){
                if (content.count { it == k } > 1)
                    content = ""
            }

            if (content != "")
                result.add(content.length)

        }
    }


    return if (result.isNotEmpty()) result.max() else 0
}


fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    var left = 0
    val seen = mutableSetOf<Char>()

    for (current in s.indices) {
        val currentChar = s[current]

        while (seen.contains(currentChar)) {
            seen.remove(s[left])
            left++
        }

        seen.add(currentChar)
        maxLength = maxOf(maxLength, current - left + 1)
    }

    println(seen)
    return maxLength
}


fun main() {
    lengthOfLongestSubstring("bbbbbb")
    lengthOfLongestSubstring("pwwkew")
    lengthOfLongestSubstring("abcabcbb")
    lengthOfLongestSubstring("nngatbhsesb")
    lengthOfLongestSubstring("dvdf")
    lengthOfLongestSubstring("asjrgapa")
    lengthOfLongestSubstring("xaxhifdzyuddj")
    lengthOfLongestSubstring("uiggtyqjt")
    println(lengthOfLongestSubstring("ohomm"))
    println(lengthOfLongestSubstring("anviaj"))

//    println(lengthOfLongestSubstring("bbbbbb"))
//    println(lengthOfLongestSubstring("pwwkew"))
//    println(lengthOfLongestSubstring("abcabcbb"))
}