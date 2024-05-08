package org.example.BinarySearch;

/*
162. Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums.length == 0){
            return 0;
        }
        if(nums.length == 2){
            if(nums[0] > nums[1]){
                return 0;
            }
            else if(nums[0] < nums[1]){
                return 1;
            }
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]){
            return (nums.length - 1);
        }
        int l = 1;
        int r = nums.length - 2;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] > nums[mid + 1]){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return 0;
    }
}
