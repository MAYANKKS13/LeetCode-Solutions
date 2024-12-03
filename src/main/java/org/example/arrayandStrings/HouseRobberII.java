package org.example.arrayandStrings;

public class HouseRobberII {
    public static void main(String[] args) {
        int nums[] = new int[]{2,3,2};
        int nums1[] = new int[]{1,2,3,1};
        System.out.println(rob(nums));
        System.out.println(rob(nums1));
/*3, 4 */
    }
    public static int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(getMaxRob(nums, 0, nums.length - 2), getMaxRob(nums, 1, nums.length - 1));

    }
    public static int getMaxRob(int[] nums, int start, int end) {
        int a = 0, b = 0;
        for(int i = start; i <= end; i++) {
            int temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }

}
