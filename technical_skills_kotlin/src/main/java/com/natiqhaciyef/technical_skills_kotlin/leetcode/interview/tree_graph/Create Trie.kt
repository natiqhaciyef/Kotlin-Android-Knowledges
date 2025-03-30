package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph


class Trie() {
    private data class TrieNode(val children: MutableMap<Char, TrieNode> = mutableMapOf())
    private val root = TrieNode()
    private val list = mutableListOf<String>()

    fun insert(word: String) {
        list.add(word)
        var current = root
        var index = 0

        while(index < word.length){
            val ch = word[index]
            if(current.children[ch] == null)
                current.children[ch] = TrieNode()

            current = current.children[ch]!!

            index += 1
        }

    }

    fun search(word: String): Boolean {
        return list.contains(word)
    }

    fun startsWith(prefix: String): Boolean {
        if(root.children.keys.isEmpty()) return false
        var current = root
        var index = 0

        while(index < prefix.length) {
            val ch = prefix[index]
            if(current.children[ch] != null){
                current = current.children[ch]!!
            }
            else
                return false

            index += 1
        }

        return true
    }

}