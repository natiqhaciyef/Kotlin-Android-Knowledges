package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.util.PriorityQueue

/**
 * The Goal:
Imagine you have a list of numbers. Your job is to make every number in this list zero. You have a
set of special tools (let's call them "actions"). Each action can reduce numbers within a specific
range in your list. If an action covers a number, you can use that action to reduce that number by
1) The trick is, each number might need to be reduced multiple times (e.g., if it's a 5, it needs
five such reductions from five distinct actions or five applications from actions if one action can
be used multiple times - in this problem, it's about getting enough *distinct query effects).
We want to achieve our goal of making all numbers zero by using the *fewest possible actions.
The final answer we're looking for is how many actions we didn't have to use.

 * Our General Approach: Being Smart and Greedy
 We'll go through our list of numbers one by one, from left to right. For each number, we'll figure
out what actions are needed. When we have a choice of which new action to use, we'll pick one that
not only helps with the current number but also seems most helpful for the numbers further down the
list. This "most helpful for the future" usually means picking an action that covers the current
number and extends as far to the right as possible.

 * Step-by-Step Plan:
1. Initial Checks (Can it even be done?):
 - First, if all the numbers in our list are already zero, we don't need any actions! We can save all of them.
 - Then, look at each number in the list. If any number needs, say, 10 reductions, but we only have 5
actions in total, it's impossible. We stop and say it can't be done.
 - Also, if we have numbers to reduce but no actions at all, it's impossible.

2. Get Organized:
 -  It's helpful to know when each action can start being useful. So, we'll sort all our available
actions based on their starting position in the list.

3. Processing the List, Number by Number:
 - We'll walk from the first number in our list to the last. Let's say we're currently looking at a
specific position (or index) in the list.
 - A. Clean Up Old Actions: Some actions we might have decided to use for previous numbers might have
ended by now (their range doesn't cover the current position anymore). We'll note that these are no
longer "actively helping" at this exact spot. We need an efficient way to know which ones have ended.

 - B. Find Potential New Helpers: We'll look at our sorted list of all available actions. Any action
that starts at or before our current position, and that we haven't used yet, is now a "candidate" –
we could potentially choose to use it. We'll gather all these new candidates. It's good to have
these candidates organized so we can easily pick the one that extends furthest to the right.

 - C. Check the Current Number's Needs:
  * Look at the number at our current position. If it's already zero (or effectively needs zero more
 reductions), we move to the next position in the list.
  * Otherwise, this number needs a certain amount of reduction (let's say it needs 'X' more reductions).

 - D. See Who's Already Helping: Count how many of the actions we've *already chosen and are still
active are covering our current position. Let's say 'Y' active actions are helping.

 - E. Do We Need More Help? If the number needs 'X' reductions and 'Y' active actions are already
helping, we still need to find ('X' minus 'Y') more actions.

 - F. Picking New Actions (The Greedy Part): If we do need more actions:
  * For each additional action required, we look at our current "candidate" actions (from step B).
  * From these candidates, we pick the one that *covers our current position* AND extends furthest to the right.
 This is our smart, greedy choice.
  * Once we pick an action:
  * We mark it as "used" so we don't pick it again to be activated (though it can continue to help future numbers it covers).
  * We add it to our list of "active" actions.
  * We count it towards the total number of actions we've decided to use.
  * Uh Oh! No Helpers? If we need to pick an action, but there are no unused candidate actions left
 that actually cover our current position, then it's impossible to make the current number zero.
 We stop and declare the whole task impossible.

4. The Grand Finale:
If we successfully go through every number in our list without declaring it impossible, then the
total count of actions we decided to "use" is the minimum number needed.

The final answer is: (The total number of actions we started with) - (The minimum number of actions
we actually used). This tells us the maximum number of actions we could afford to remove.

This way, by making locally optimal choices (picking actions that cover the current need and go furthest),
we aim for a globally optimal solution (using the minimum total number of actions). The use of
organized lists for "active" and "candidate" actions helps make these decisions quickly.

 * */

fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
    // Topics: Array, Greedy, Sorting, Heap (Priority Queue), Prefix Sum
    val n = nums.size
    val totalQueries = queries.size

    // all edge cases
    if (nums.all { it == 0 }) {
        return totalQueries
    }
    for (num in nums) {
        if (num > totalQueries) { // Cannot satisfy if a requirement is > total available queries
            return -1
        }
    }
    if (totalQueries == 0 && nums.any { it > 0 }) { // nums need reduction but no queries
        return -1
    }


    // Store queries as (left index, right index, original index) and sort by left index
    val indexedQueries = queries.mapIndexed { index, query ->
        intArrayOf(query[0], query[1], index)
    }.sortedWith(compareBy({ it[0] }, { it[1] })) // Sort by left index, then right index

    val used = BooleanArray(totalQueries)
    var queriesUsedCount = 0

    // Min-priority queue for end points (right index) of active queries
    val activeQueriesEndTimePQ = PriorityQueue<Int>()

    // Max-priority queue for candidate queries: Pair(right index, original query index)
    // Ordered by ri (descending)
    val candidateQueriesPQ = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first })

    var allQueriesPtr = 0 // Pointer for iterating through `indexedQueries`

    for (i in 0 until n) {
        // 1. Remove queries from activeQueriesEndTimePQ that no longer cover index i
        while (activeQueriesEndTimePQ.isNotEmpty() && activeQueriesEndTimePQ.peek() < i) {
            activeQueriesEndTimePQ.poll()
        }

        // 2. Add newly available queries (those with leftIndex <= i) to candidateQueriesPQ
        while (allQueriesPtr < indexedQueries.size && indexedQueries[allQueriesPtr][0] <= i) {
            val query = indexedQueries[allQueriesPtr]
            // Only add if not already used (a query is offered to candidatePQ only once due to allQueriesPtr)
            if (!used[query[2]]) { // query[2] is the original index
                candidateQueriesPQ.add(Pair(query[1], query[2])) // Add (rightIndex, original index)
            }
            allQueriesPtr += 1
        }

        val hitsNeeded = nums[i]
        if (hitsNeeded == 0) {
            continue
        }

        val coverageFromActive = activeQueriesEndTimePQ.size
        val additionalActivationsNeeded = hitsNeeded - coverageFromActive

        if (additionalActivationsNeeded > 0) {
            for (k in 0 until additionalActivationsNeeded) {
                var chosenCandidateOriginalIndex: Int = -1
                var chosenCandidateEndTime: Int = -1

                // Find the best valid candidate
                while (candidateQueriesPQ.isNotEmpty()) {
                    val candidate = candidateQueriesPQ.peek()
                    if (used[candidate.second]) { // If somehow already marked used (e.g. by a previous shortfall for same i, though this loop structure avoids that)
                        candidateQueriesPQ.poll() // Remove and ignore
                        continue
                    }
                    if (candidate.first < i) { // This candidate query ends before current index i
                        candidateQueriesPQ.poll() // Remove and ignore
                        continue
                    }
                    // Valid candidate found
                    val polledCandidate = candidateQueriesPQ.poll()
                    chosenCandidateOriginalIndex = polledCandidate.second
                    chosenCandidateEndTime = polledCandidate.first
                    break
                }

                if (chosenCandidateOriginalIndex != -1) {
                    activeQueriesEndTimePQ.add(chosenCandidateEndTime)
                    used[chosenCandidateOriginalIndex] = true
                    queriesUsedCount+=1
                } else {
                    // Not enough suitable candidates found
                    return -1
                }
            }
        }
    }

    return totalQueries - queriesUsedCount
}

fun main() {
    println("1st Result")
    val result1 = maxRemoval(
        intArrayOf(1, 2, 2, 1, 0, 1),
        queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 5))
    )
    println(result1)


    println("")
    println("")
    println("2nd Result")
    val result2 = maxRemoval(
        intArrayOf(2, 0, 2),
        arrayOf(intArrayOf(0, 2), intArrayOf(0, 2), intArrayOf(1, 1))
    )
    println(result2)


    println("")
    println("")
    println("3rd Result")
    val result3 = maxRemoval(
        intArrayOf(1, 1, 1, 1),
        arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 2))
    )
    println(result3)


    println("")
    println("")
    println("4th Result")
    val result4 = maxRemoval(
        intArrayOf(1, 2, 3, 4),
        arrayOf(intArrayOf(0, 3))
    )
    println(result4)


    println("")
    println("")
    println("5th Result")
    val result5 = maxRemoval(
        intArrayOf(0, 3),
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(0, 1),
            intArrayOf(0, 0)
        )
    )
    println(result5)

    println("")
    println("")
    println("6th Result")
    val result6 = maxRemoval(
        intArrayOf(4, 1),
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
    )
    println(result6)


    val name = "Hello"
    println(name.replace(name[0], name[0] + 32))
}