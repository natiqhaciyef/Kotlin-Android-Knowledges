package com.natiqhaciyef.technical_skills_java.algorithms;

// All examples return index of element in nums array (if array doesn't contain element then returns -1)

class LinearSearch {

    /**
     * Common/General search way of linear search (CLS or GLS)
     * The main problem in this example is the repeated search, even if the index of the element is found.
     * It repeats more than expected. All examples returns O(n) n = nums.size
     *
     * @param nums is the container of elements, element is the searched one.
     * @return index of element, if element not found -1
     */

    public static int linearSearch(int[] nums, int element) {
        int index = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == element) {
                index = i;
            }
        }
        return index;
    }


    /**
     * Better linear search (BLS)
     * BetterLinearSearch solves 2 problems in CommonLinearSearch.
     * First, when element is found then stops repeating search. Second is no more index variable
     * should be created. Even if it is the optimal solution than linear search, it is not the best way
     * of linear search algorithms.
     * Because, it creates =>  n * 2 * condition
     * n = loops count
     * condition = if-else statement
     * Why 2 * condition ? Because, "i in nums.indices" is first conditional case, "nums[i] == element" is the
     * second conditional case.
     *
     * @param nums is the container of elements, element is the searched one.
     * @return index of element, if element not found in the nums then returns -1
     */
    public static int betterLinearSearch(int[] nums, int element) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == element) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Sentinel linear search (BLS)
     * SentinelLinearSearch solves 2 problems in CommonLinearSearch.
     * First, when element is found then stops repeating search. Second is no more index variable
     * should be created. Even if it is the optimal solution than linear search, it is not the best way
     * of linear search algorithms.
     *
     * @param nums is the container of elements, element is the searched one.
     * @return index of element, if element did not find in the nums then returns -1
     */
    public static int sentinelLinearSearch(int[] nums, int element) {
        int last = nums.length - 1;
        int holder = nums[last];
        nums[last] = element;

        int index = 0;
        while (nums[index] != element) {
            index += 1;
        }

        nums[last] = holder;
        if (nums[last] == element || index < last) return index;

        return -1;
    }

}