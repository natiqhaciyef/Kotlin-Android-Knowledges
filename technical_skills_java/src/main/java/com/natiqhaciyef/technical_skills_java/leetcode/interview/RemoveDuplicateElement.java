package com.natiqhaciyef.technical_skills_java.leetcode.interview;

public class RemoveDuplicateElement {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int current = 1;
        for (int index = 1; index < nums.length; index += 1) {

            if (nums[index] != nums[index - 1]) {
                nums[current] = nums[index];
                current += 1;
            }
        }

        return current;
    }
}
