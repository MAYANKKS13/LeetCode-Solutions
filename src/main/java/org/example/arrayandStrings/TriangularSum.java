package org.example.arrayandStrings;

public class TriangularSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] nums1 = new int[] {5};
        System.out.println(triangularSum(nums));
        System.out.println(triangularSum(nums1));
//		System.out.println(triangularSum(4, 333));
    }

    public static int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        while(n > 0)
        {
            for(int i = 0; i < n-1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }
        return nums[0];
    }
}
