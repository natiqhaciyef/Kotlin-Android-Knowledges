package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {
    private var children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) {
        children.add(child)
    }

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)

        val queue = QueueImpl<TreeNode<T>>()

        children.forEach {
            queue.enqueue(it)
        }

        var node = queue.dequeue()

        while (node != null) {
            visit(node)

            node.children.forEach { queue.enqueue(it) }

            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachDepthFirst {
            if (it.value == value)
                result = it
        }

        return result
    }

    fun printEachLevel() {
        val queue = QueueImpl<TreeNode<T>>()
        var currentLine = 0

        queue.enqueue(this)

        while (!queue.isEmpty) {
            currentLine = queue.count

            loop@while (currentLine > 0) {
                val node = queue.dequeue()

                if (node != null) {
                    node.children.forEach { queue.enqueue(it) }
                    println("${node.value}")

                    currentLine -= 1
                } else
                    break@loop
            }

            println()
        }
    }
}


fun main() {
    val beverages = TreeNode("beverages")
    val hotDrinks = TreeNode("hot")
    val coldDrinks = TreeNode("cold")

    val tea = TreeNode("tea")
    tea.add(TreeNode("green tea"))
    tea.add(TreeNode("black tea"))
    tea.add(TreeNode("milk tea"))

    val coffee = TreeNode("coffee")
    coffee.add(TreeNode("espresso"))
    coffee.add(TreeNode("americano"))
    coffee.add(TreeNode("cappuccino"))
    coffee.add(TreeNode("latte"))

    val alcohol = TreeNode("alcohol")
    alcohol.add(TreeNode("beer"))
    alcohol.add(TreeNode("vodka"))

    val nonAlcohol = TreeNode("non alcohol")
    nonAlcohol.add(TreeNode("sprite"))
    nonAlcohol.add(TreeNode("cola"))
    nonAlcohol.add(TreeNode("ice water"))


    hotDrinks.add(coffee)
    hotDrinks.add(tea)
    beverages.add(hotDrinks)

    coldDrinks.add(alcohol)
    coldDrinks.add(nonAlcohol)
    beverages.add(coldDrinks)

    println("-------------Vertical tree list-------------")
    beverages.forEachDepthFirst { println(it.value) }

    println("")

    println("-------------Horizontal tree list-------------")
    beverages.forEachLevelOrder { println(it.value) }

    println("")

    println("-------------Searched tree value-------------")
    beverages.search("non alcohol")?.forEachLevelOrder { println(it.value) }

    println("")

    println("-------------Print each layer-------------")
    beverages.printEachLevel()

}

