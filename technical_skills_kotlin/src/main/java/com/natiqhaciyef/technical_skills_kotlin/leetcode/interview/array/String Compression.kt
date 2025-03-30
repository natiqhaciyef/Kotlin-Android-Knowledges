package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.array

fun compressWorst(chars: CharArray): Int {
    if(chars.size <= 1) return chars.size

    var str = ""
    var count = 1

    for(i in 0 until chars.size-1){
        if(chars[i] == chars[i+1]){
            count+=1
        }else{
            str += chars[i]
            if(count > 1){
                str+=count
                count = 1
            }
        }
    }

    str += chars[chars.size-1]
    if(count > 1){
        str += count
    }

    for(i in str.indices){
        chars[i] = str[i]
    }

    return str.length
}


fun compress(chars: CharArray): Int {
    if (chars.isEmpty()) return 0

    var writeIndex = 0 // Position to write compressed characters
    var readIndex = 0  // Position to read characters

    while (readIndex < chars.size) {
        val currentChar = chars[readIndex]
        var count = 0

        // Count occurrences of the current character
        while (readIndex < chars.size && chars[readIndex] == currentChar) {
            count++
            readIndex++
        }

        // Write the character
        chars[writeIndex++] = currentChar

        // Write the count if more than 1
        if (count > 1) {
            for (c in count.toString()) {
                chars[writeIndex++] = c
            }
        }
    }

    return writeIndex
}