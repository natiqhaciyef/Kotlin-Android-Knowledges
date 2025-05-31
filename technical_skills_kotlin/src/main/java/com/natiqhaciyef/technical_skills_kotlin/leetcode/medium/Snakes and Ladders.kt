package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun snakesAndLadders(board: Array<IntArray>): Int {
    // [1,1,1,1]
    // [1,1,1,1]
    // [1,1,1,1]
    // [1,1,1,1]

    // convert them to line
    var current = 1
    val list = mutableListOf<Int>()
    var isReversed = false
    for (i in board.size - 1 downTo 0) {
        val line = board[i]
        if (isReversed){
            for (cell in line.size-1 downTo 0) {
                if (line[cell] == -1)
                    list.add(current)
                else
                    list.add(line[cell])

                current += 1
            }

            isReversed = false
        }else {
            for (cell in line.indices) {
                if (line[cell] == -1)
                    list.add(current)
                else
                    list.add(line[cell])

                current += 1
            }
            isReversed = true
        }

    }

    println("list => $list")
    println("-------")


    // using bfs
    val possible = mutableMapOf<Int, MutableList<Int>>()

    for (j in list.indices) {
        var k = j
        val key = j + 1

        if (k + 6 < list.size){
            val limit = j+6

            while (k < limit) {
                k += 1

                val possibleList = possible.getOrDefault(key, mutableListOf())

                possibleList.add(list[k])
                possible[key] = possibleList
            }
        }else{
            while (k < list.size-1) {
                k += 1

                val possibleList = possible.getOrDefault(key, mutableListOf())
                possibleList.add(list[k])
                possible[key] = possibleList
            }
        }
    }

    val decisionTree = buildDecisionTree(1, possible)
    val result = bfs(decisionTree, list.size)
    println("RESULT ======> $result")


    for ((key, value) in possible){
        println("key => $key")
        println("values => $value")

        println("----------")
    }



    return result
}

fun bfs(root: DecisionTree, max: Int): Int {
    val queue: ArrayDeque<Pair<DecisionTree, Int>> = ArrayDeque()
    val visited = mutableSetOf<Int>()

    queue.add(root to 0)

    while (queue.isNotEmpty()) {
        val (node, steps) = queue.removeFirst()

        if (node.node == max) {
            return steps
        }

        if (visited.contains(node.node)) continue
        visited.add(node.node)

        for (nei in node.neighbours) {
            queue.add(nei to steps + 1)
        }
    }

    return -1
}

class DecisionTree(val node: Int) {
    var neighbours: MutableList<DecisionTree> = mutableListOf()
}

fun buildDecisionTree(rootValue: Int, data: Map<Int, MutableList<Int>>): DecisionTree {
    val nodeMap = mutableMapOf<Int, DecisionTree>()

    fun getNode(value: Int): DecisionTree {
        return nodeMap.getOrPut(value) { DecisionTree(value) }
    }

    val root = getNode(rootValue)

    for ((parent, children) in data) {
        val parentNode = getNode(parent)
        for (child in children) {
            val childNode = getNode(child)
            parentNode.neighbours.add(childNode)
        }
    }

    return root
}



fun main() {
    val board1 = arrayOf(
        intArrayOf(-1, -1, 19, 10, -1),
        intArrayOf(2, -1, -1, 6, -1),
        intArrayOf(-1, 17, -1, 19, -1),
        intArrayOf(25, -1, 20, -1, -1),
        intArrayOf(-1, -1, -1, -1, 15)
    )

    val board2: Array<IntArray> = arrayOf(
        intArrayOf(2, -1, -1, -1, -1),
        intArrayOf(-1, -1, -1, -1, -1),
        intArrayOf(-1, -1, -1, -1, -1),
        intArrayOf(-1, -1, -1, -1, -1),
        intArrayOf(-1, -1, -1, -1, -1)
    )



//    snakesAndLadders(board1)
    snakesAndLadders(board2)
}