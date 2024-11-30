package com.natiqhaciyef.technical_skills_java.leetcode.interview;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int count = 0;

        for (int current = nums.length - 1; current > 0; current--) {
            if (nums[current] != val) {
                for (int next = current - 1; next >= 0; next--) {
                    if (nums[next] == val) {
                        nums[next] = nums[current];
                        nums[current] = val;
                        System.out.println("Next: " + nums[next]);
                        System.out.println("Current: " + nums[current]);
                    }
                }
            }
        }

        for (int num : nums) {
            if (num != val)
                count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int[] arr2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(arr2, 2));
    }
}
