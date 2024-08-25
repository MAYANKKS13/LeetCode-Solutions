package org.example.Intervals;

/*
228. Summary Ranges

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

 */

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        int[] nums1 = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
        System.out.println(summaryRanges(nums1));

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        int left = 0;
        for(int i = 0; i < nums.length - 1; i++) {
           if(nums[i + 1] - nums[i] != 1) {
               if(left == i) {
                   result.add(String.valueOf(nums[left]));
               }
               else {
                   result.add(String.valueOf(nums[left]) + "->" + String.valueOf(nums[i]));
               }
               left = i + 1;
           }
        }
        if(left == nums.length - 1) {
            result.add(String.valueOf(nums[left]));
        }
        else {
            result.add(String.valueOf(nums[left]) + "->" + String.valueOf(nums[nums.length - 1]));
        }
        return result;
    }

}
