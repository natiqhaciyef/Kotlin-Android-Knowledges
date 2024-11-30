package com.natiqhaciyef.technical_skills_java.leetcode.interview;

public class MajorityElement {

    // nums - [38, 27, 43, 10]
    public static void mergeSort(int[] nums, int element) {
        if (element < 2)
            return;

        // to separate nums []
        int mid = element / 2;

        int[] left = new int[mid];
        int[] right = new int[element - mid];

        // left - [38, 27] // left -> [38]
        for (int i = 0; i < mid; i++)
            left[i] = nums[i];

        // right - [43, 10] // right -> [27]
        for (int i = mid; i < element; i++)
            right[i - mid] = nums[i];


        mergeSort(left, mid); // left-left [38] left-right [27]
        mergeSort(right, element - mid); // right-left [43] right-right [10]

        // [38,27] - [38], [27] - 1 - 1
        merge(nums, left, right, mid, element - mid);
    }

    // [38, 27, 43, 10] -> left - [38, 27] & right - [43, 10]
    // left-left [38] | left-right [27]  |||  right-left [43] | right-right [10]
    public static void merge(int[] nums, int[] leftArray, int[] rightArray, int left, int right) {
        int leftArrayIndex = 0, rightArrayIndex = 0, numsIndex = 0;

        // [38] & [27]
        while (leftArrayIndex < left && rightArrayIndex < right) {
            // [38] <= [27]
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex])
                nums[numsIndex++] = leftArray[leftArrayIndex++];
            else
                nums[numsIndex++] = rightArray[rightArrayIndex++]; // nums[0] = 27 -> numsIndex = 1, rightArrayIndex = 1
        }

        // leftArrayIndex = 0 < left = 1 (will be executed)
        while (leftArrayIndex < left)
            nums[numsIndex++] = leftArray[leftArrayIndex++];

        // rightArrayIndex = 1 < right = 1 (will not be executed)
        while (rightArrayIndex < right)
            nums[numsIndex++] = rightArray[rightArrayIndex++];
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        mergeSort(nums, length);
        return nums[length / 2];
    }
}
