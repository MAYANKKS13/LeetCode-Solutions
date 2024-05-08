package org.example.BinarySearch;

/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

public class MedianofTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int value = 0;
        int middleLeft = 0;
        while (count <= (m + n)/2){
            middleLeft = value;
            if(i < n && j < m){
                if(nums1[i] < nums2[j]) {
                    value = nums1[i];
                    i++;
                }
                else {
                    value = nums2[j];
                    j++;
                }
            } else if (j < m) {
                value = nums2[j];
                j++;
            }
            else {
                value = nums1[i];
                i++;
            }
            count++;
        }


        if((m+n)%2 != 0) {
            return (double) value;
        }
        else{
            return ((double) middleLeft + (double) value)/2;
        }

    }
}
