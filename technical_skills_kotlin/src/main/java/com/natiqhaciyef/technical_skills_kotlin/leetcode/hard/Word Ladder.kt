package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

// Non optimized version
fun ladderLengthBruteForce(beginWord: String, endWord: String, wordList: List<String>): Int {
    if (wordList.isEmpty()) return 0

    // we should find the nearest string in wordList (also near to the end)
    // we should find the result in list

    fun differenceCount(): Int {
        var diff = 0
        var j = 0

        while (j < beginWord.length) {
            if (beginWord[j] != endWord[j])
                diff += 1
            j += 1
        }

        return diff
    }

    fun isSingleDiff(str1: String, str2: String): Boolean {
        var diff = 0
        var i = 0

        while (i < str1.length) {
            if (str1[i] != str2[i])
                diff += 1

            i += 1
        }

        return diff == 1
    }

    // collect all possible
    // check all steps one by one

    // create hashmap like graph
    val map = mutableMapOf<String, MutableList<String>>()
    var isBeginWordContains = false
    for (i in wordList.indices) {
        val word1 = wordList[i]
        val currentList = map.getOrDefault(word1, mutableListOf())

        if (wordList[i] == beginWord)
            isBeginWordContains = true

        for (j in wordList.indices) {
            if (j == i) continue

            val word2 = wordList[j]
            if (isSingleDiff(word1, word2))
                currentList.add(word2)
        }

        map[word1] = currentList
    }

//    println("map => $map")


    // from start index
    if (!isBeginWordContains) {
        val strList = mutableListOf<String>()

        for (word in wordList) {
            if (isSingleDiff(beginWord, word))
                strList.add(word)
        }

        map[beginWord] = strList
    }

    // bfs for find the shortest path
    val queue = ArrayDeque<String>()
    val visited = mutableSetOf<String>()

    // if there is begin word then pick it as a first, if not first element is first.
    queue.addFirst(beginWord)
    visited.add(beginWord)

    var resultDepth = Int.MAX_VALUE
    fun bfs(word: String, depth: Int) {
        if (queue.isEmpty())
            return

        if (word == endWord) {
            resultDepth = minOf(depth, resultDepth)
        }


        val first = queue.removeFirst()

        val list = map[first] ?: listOf()

//        println(list)
        for (nei in list) {
            if (nei !in visited) {
                queue.addLast(nei)
                visited.add(nei)
                bfs(nei, depth + 1)
                visited.remove(nei)
            }
        }
    }


    bfs(beginWord, 1)
//    println(resultDepth)

    // also if bfs result lower than diff it means something wrong we will return 0 in that case
    val diff = differenceCount()
    return if (resultDepth < diff || resultDepth == Int.MAX_VALUE) 0 else resultDepth
}


// Optimized
/**
 * Finds the length of the shortest transformation sequence from beginWord to endWord.
 *
 * This solution uses a Breadth-First Search (BFS) algorithm, which is ideal for finding the
 * shortest path in an unweighted graph.
 *
 * Time Complexity: O(N * L^2), where N is the number of words in the list and L is the length of the words.
 * - The BFS will visit each of the N words at most once.
 * - For each word, we iterate through its L characters.
 * - For each character, we try 25 other letters.
 * - Creating the new string from the char array takes O(L).
 * - This results in O(N * L * 26 * L) = O(N * L^2) work.
 *
 * Space Complexity: O(N * L) to store the wordSet, the queue, and visited words.
 *
 * @param beginWord The starting word.
 * @param endWord The target word.
 * @param wordList The list of available words for transformation.
 * @return The length of the shortest transformation sequence, or 0 if no such sequence exists.
 */
fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    // Use a mutable set for efficient O(1) average time complexity for lookups and removals.
    val wordSet = wordList.toMutableSet()

    // If the endWord is not in our dictionary, a transformation is impossible.
    if (endWord !in wordSet) {
        return 0
    }

    // The queue for our BFS will store the words to visit.
    val queue: ArrayDeque<String> = ArrayDeque()
    queue.add(beginWord)

    // The length of the transformation sequence starts at 1 (for the beginWord).
    var level = 1

    // A set to keep track of words we've already added to the queue to avoid cycles
    // and redundant processing.
    val visited = mutableSetOf(beginWord)

    while (queue.isNotEmpty()) {
        // Process all words at the current level of the search.
        val levelSize = queue.size
        for (i in 0 until levelSize) {
            val currentWord = queue.removeFirst()

            // If we've reached the endWord, we've found the shortest path.
            if (currentWord == endWord) {
                return level
            }

            // --- Generate all possible transformations (neighbors) of the currentWord ---
            val currentWordChars = currentWord.toCharArray()
            for (j in currentWordChars.indices) {
                val originalChar = currentWordChars[j]

                // Try changing the character at the current position 'j' to every letter from 'a' to 'z'.
                for (char in 'a'..'z') {
                    if (currentWordChars[j] == char) {
                        continue
                    }

                    currentWordChars[j] = char
                    val newWord = String(currentWordChars)

                    // If the newWord exists in our word list and we haven't visited it yet...
                    if (newWord in wordSet && newWord !in visited) {
                        // ...add it to the queue and mark it as visited.
                        visited.add(newWord)
                        queue.addLast(newWord)
                    }
                }

                // IMPORTANT: Change the character back to the original to generate transformations
                // for the next position.
                currentWordChars[j] = originalChar
            }
        }
        // After processing all words at the current level, move to the next level.
        level++
    }

    // If the queue becomes empty and we haven't found the endWord, no path exists.
    return 0
}


fun main() {
    val result1 = ladderLengthBruteForce("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
    println("----")
    val result2 = ladderLengthBruteForce("hit", "cog", listOf("hot", "dul", "dog", "lot", "log", "cog"))
    println("----")
    val result3 = ladderLengthBruteForce("hot", "dog", listOf("hot","dog","dot"))
    println("result1 = $result1")
    println("result2 = $result2")
    println("result3 = $result3")
}