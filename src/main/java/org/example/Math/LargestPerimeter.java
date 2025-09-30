package org.example.Math;

import java.util.Arrays;

public class LargestPerimeter {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,2};
        int[] nums1 = new int[] {1,2,1,10};
        System.out.println(largestPerimeter(nums));
        System.out.println(largestPerimeter(nums1));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i++) {
            if(nums[i-2] + nums[i-1] > nums[i]) {
                return (nums[i-2] + nums[i-1] + nums[i]);
            }
        }
        return 0;
    }
}
