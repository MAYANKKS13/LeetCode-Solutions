package org.example.arrayandStrings;

public class MaximumValueofanOrderedTripletII {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        int[] nums1 = {1,10,3,4,19};
        int[] nums2 = {1, 2, 3};
        System.out.println(maximumTripletValue(nums));
        System.out.println(maximumTripletValue(nums1));
        System.out.println(maximumTripletValue(nums2));
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int diff[] = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            diff[i] = max - nums[i];
        }

        int maxValue = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = Math.max(ans, maxValue * diff[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        return ans;

    }


}
