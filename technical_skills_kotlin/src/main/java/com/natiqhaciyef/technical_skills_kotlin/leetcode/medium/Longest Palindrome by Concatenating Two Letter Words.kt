package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun longestPalindrome1(words: Array<String>): Int {
    // iterate each word and search reversed version in current list
    // if there is current

    // conditions
    // if word length is even or odd =>  add to result when
    //  - if palindrome
    //  - if contains reversed in current words list

    val map = mutableMapOf<String, Int>()
    val wordsCopy = words.toMutableList()
    var i = 0
    var result = 0

    for (word in words) {
        if (isPalindrome(word))
            map[word] = map.getOrDefault(word, 0) + 1
    }

    // en uzun tapildi
    var longestPalindrome = ""
    for ((key, value) in map) {
        if (value % 2 == 1 && longestPalindrome.length < key.length){
            longestPalindrome = key
        }
    }

    if (longestPalindrome.isNotEmpty()){
        wordsCopy.remove(longestPalindrome)
    }

    while(wordsCopy.isNotEmpty() && i < wordsCopy.size){
        val currentWord = wordsCopy[i]

        if(currentWord != currentWord.reversed() && wordsCopy.contains(currentWord.reversed())){
            result += (currentWord.length * 2)
            wordsCopy.remove(currentWord.reversed())
            wordsCopy.remove(currentWord)
            i -= 1
        }else if(currentWord == currentWord.reversed()){
            var count = wordsCopy.count { it == currentWord }
            if(count %2 != 0)
                count -= 1

            var j = 0
            while (j < count){
                result += currentWord.length
                wordsCopy.remove(currentWord)
                j+=1
            }


            i -= 1
        }

        i += 1
    }

    return result
}

fun isPalindrome(word: String): Boolean {
    val length = word.length
    val half = length / 2

    for (i in 0 until half) {
        if (word[i] != word[length - i - 1])
            return false
    }

    return true
}


fun longestPalindrome2(words: Array<String>): Int {
    val freq = mutableMapOf<String, Int>()
    var result = 0
    var centralPalindromeUsed = false

    // Count frequencies
    for (word in words) {
        freq[word] = freq.getOrDefault(word, 0) + 1
    }

    for ((word, count) in freq.toMap()) {
        val reversed = word.reversed()

        if (word == reversed) {
            // Palindromic word like "aa", "bb"
            val pairs = count / 2 // (it will remove extra palindromic pairs such as if you have 5 "aa" => 5/2 == 2, so 1 of them will ignored)
            result += pairs * 2
            freq[word] = count % 2

            if (!centralPalindromeUsed && freq[word] == 1) {
                // Use one as the center if available
                result += 1
                centralPalindromeUsed = true
            }

        } else if (freq.containsKey(reversed)) {
            val pairCount = minOf(freq[word] ?: 0, freq[reversed] ?: 0)
            result += pairCount * 2
            freq[word] = freq[word]!! - pairCount
            freq[reversed] = freq[reversed]!! - pairCount
        }
    }

    return result * words[0].length
}