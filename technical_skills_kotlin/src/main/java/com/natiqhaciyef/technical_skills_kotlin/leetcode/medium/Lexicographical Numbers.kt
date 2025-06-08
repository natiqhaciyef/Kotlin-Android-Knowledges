package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


// TODO: BUT NEED UPGRADE => TIME COMPLEXITY O(N) & SPACE COMPLEXITY O(1)
class Trie {
    val children: MutableMap<Char, Trie> = mutableMapOf()
}

fun lexicalOrder(n: Int): List<Int> {
    // Topics: DFS, Trie
    val head = Trie()
    var str: String

    // Time Complexity max => O(4) + O(N)
    for (i in 1..n) {
        str = i.toString()

        var trie = head
        // Time complexity => O(4)
        for (j in str.indices) {
            trie = trie.children.getOrPut(str[j]) { Trie() }
        }
    }


    val list = mutableSetOf(head.children.keys.first().toString())

    // Space Complexity O(N)
    fun dfs(node: Trie, str: String){
        // pre order dfs
        if (str.isNotEmpty())
            list.add(str)
        
        if (node.children.values.isEmpty()){
            return
        }

        for ((key, value) in node.children){
            dfs(value, str + key)
        }
    }

    dfs(head, "")

    // Time complexity => O(N)

    val result = mutableListOf<Int>()
    for (element in list){
        result.add(element.toInt())
    }
    return result
}
