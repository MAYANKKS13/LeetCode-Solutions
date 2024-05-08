package org.example.HashMap;

/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums.length == 0){
            max = 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] + 1)){
                int count = 1;
                int value = nums[i];
                while(set.contains(value - 1)){
                    count++;
                    value = value - 1;
                }
                if(count > max){
                    max = count;
                }
            }
        }
        return max;

    }
}
