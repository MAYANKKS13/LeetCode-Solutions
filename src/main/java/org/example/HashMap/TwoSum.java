package org.example.HashMap;

/*
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> putIndex = new HashMap<>();
        int n = nums.length;
        for(int i=0;i< n;i++){
            if(putIndex.containsKey(target - nums[i])) {
                return new int[]{i, putIndex.get(target - nums[i])};
            }
            putIndex.put(nums[i],i);
        }
        return new int[]{0, 0};
    }
}
