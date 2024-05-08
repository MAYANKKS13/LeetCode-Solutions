package org.example.arrayandStrings;

/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        int multiply = 1;
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZero++;
                continue;
            }
            multiply = multiply * nums[i];
        }
        if (countZero == 0) {
            for (int j = 0; j < n; j++) {
                results[j] = multiply / nums[j];
            }
        }
        if (countZero == 1) {
            for (int j = 0; j < n; j++) {
                if(nums[j] == 0){
                    results[j] = multiply;
                }
                else{
                    results[j] = 0;
                }
            }
        }
        if (countZero > 1) {
            for(int m = 0; m < n; m++){
                results[m] = 0;
            }
        }
        return results;
    }
}
