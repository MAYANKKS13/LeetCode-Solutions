package org.example.Heap;

/*
215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

import java.util.PriorityQueue;

public class KthLargestElementinaArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }
        for(int j = k; j < nums.length; j++){
            if(nums[j] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[j]);
            }
        }
        return minHeap.poll();
    }
}
