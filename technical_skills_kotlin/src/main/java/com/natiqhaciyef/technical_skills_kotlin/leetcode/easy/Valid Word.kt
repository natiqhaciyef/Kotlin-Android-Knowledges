package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

private val vowels = arrayOf('a','A', 'i', 'I', 'e', 'E', 'o', 'O', 'u', 'U')
private fun isValid(word: String): Boolean {
    return word.length >= 3 && isOnlyDigitsAndLetters(word)
}

fun isOnlyDigitsAndLetters(word: String): Boolean {
    var containsConsonant = false
    var containsVowel = false

    for(ch in word){
        if(!ch.isDigit()){
            if(ch in vowels)
                containsVowel = true
            else
                containsConsonant = true
        }


        if(!ch.isLetterOrDigit())
            return false
    }

    return containsConsonant && containsVowel
}
