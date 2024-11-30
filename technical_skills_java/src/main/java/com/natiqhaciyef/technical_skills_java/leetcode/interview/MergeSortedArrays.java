package com.natiqhaciyef.technical_skills_java.leetcode.interview;

import java.util.ArrayList;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] != 0) {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums1[j] == 0) {
                        nums1[j] = nums2[i];
                        break;
                    }
                }
            }
        }

        // insertion sort

        System.out.print("[");
        for (int e = 0; e < nums1.length; e++) {
            if (e < nums1.length - 1)
                System.out.print(nums1[e] + ",");
            else
                System.out.print(nums1[e]);
        }

        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] arr2 = {1, 2, 2};
        merge(arr1, 6, arr2, 3);
    }
}
