package org.example.arrayandStrings;

/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int c = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        int mid = (int) Math.floor(n/2);
        set = map.keySet();
        for(Integer key : set){
            if(map.get(key) > mid){
                c = key;
                break;
            }
        }

        return c;

    }
}
