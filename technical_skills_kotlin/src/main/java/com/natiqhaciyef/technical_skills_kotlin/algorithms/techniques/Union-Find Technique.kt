package com.natiqhaciyef.technical_skills_kotlin.algorithms.techniques

class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path compression
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return

        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        } else {
            parent[rootY] = rootX
            rank[rootX] += 1
        }
    }

    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}

// Example usage
fun main() {
    val uf = UnionFind(5)
    uf.union(0, 1)
    uf.union(1, 2)
    uf.union(3, 4)
    println(uf.connected(0, 2)) // true
    println(uf.connected(0, 3)) // false
}
