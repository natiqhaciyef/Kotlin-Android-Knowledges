package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

// Support of GPT
fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
    // Sort tasks and workers to allow greedy pairing from strongest to weakest
    tasks.sort()
    workers.sort()

    // This function checks if we can assign 'k' tasks using the given constraints
    fun canAssign(k: Int): Boolean {
        val dq: ArrayDeque<Int> = ArrayDeque()

        // Take the k smallest tasks (hardest among the smallest group)
        val taskSlice = tasks.take(k)
        // Take the k strongest workers
        val availableWorkers = workers.takeLast(k)
        var j = k - 1
        var pillCount = pills

        // Start from the hardest task and try to assign workers
        for (i in k - 1 downTo 0) {
            val task = taskSlice[i] // k-th task

            // Add all available workers who can complete the task with pill help into deque
            while (j >= 0 && availableWorkers[j] + strength >= task) {
                dq.addLast(availableWorkers[j])
                j--
            }

            if (dq.isEmpty()) {
                // No available worker can handle this task even with a pill
                return false
            }

            if (dq.first() >= task) {
                // Best case: the weakest available worker can do the task without a pill
                dq.removeFirst()
            } else if (pillCount > 0) {
                // Next best: the strongest worker can do it with a pill
                dq.removeLast()
                pillCount--
            } else {
                // No pills and no one strong enough
                return false
            }
        }
        return true // Successfully assigned all k tasks
    }

    // Binary search the maximum number of tasks that can be assigned
    var left = 0
    var right = minOf(tasks.size, workers.size)

    // Standard binary search loop to find the max valid task count
    while (left < right) {
        val mid = (left + right + 1) / 2

        if (canAssign(mid)) {
            // If we can assign `mid` tasks, try more
            left = mid
        } else {
            // Otherwise, try fewer
            right = mid - 1
        }
    }

    return left // Maximum number of tasks that can be assigned
}
