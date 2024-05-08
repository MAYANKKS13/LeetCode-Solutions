package org.example.arrayandStrings;

/*
189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        k = k%n;
        for(int i = 0; i < n; i++){
            result[(i+k)%n] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}
