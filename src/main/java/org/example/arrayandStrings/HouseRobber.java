package org.example.arrayandStrings;

public class HouseRobber {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,1};
        int nums1[] = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(rob(nums1));

    }
    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }

}
