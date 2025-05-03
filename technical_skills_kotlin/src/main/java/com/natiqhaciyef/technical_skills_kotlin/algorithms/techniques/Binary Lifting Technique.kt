package com.natiqhaciyef.technical_skills_kotlin.algorithms.techniques

class BinaryLifting(val n: Int) {
    private val LOG = 20
    private val up = Array(n) { IntArray(LOG) { -1 } }
    private val depth = IntArray(n)

    fun dfs(node: Int, parent: Int, tree: List<List<Int>>) {
        up[node][0] = parent
        for (i in 1 until LOG) {
            if (up[node][i - 1] != -1) {
                up[node][i] = up[up[node][i - 1]][i - 1]
            }
        }
        for (child in tree[node]) {
            if (child != parent) {
                depth[child] = depth[node] + 1
                dfs(child, node, tree)
            }
        }
    }

    fun kthAncestor(node: Int, k: Int): Int {
        var curr = node
        for (i in 0 until LOG) {
            if ((k shr i) and 1 == 1) {
                curr = up[curr][i]
                if (curr == -1) return -1
            }
        }
        return curr
    }
}
