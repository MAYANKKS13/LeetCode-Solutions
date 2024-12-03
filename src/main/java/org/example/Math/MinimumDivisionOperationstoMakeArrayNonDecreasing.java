package org.example.Math;

public class MinimumDivisionOperationstoMakeArrayNonDecreasing {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{25, 7}));
        System.out.println(minOperations(new int[]{7, 7, 6}));
        System.out.println(minOperations(new int[]{288, 7}));

    }

    public static int minOperations(int[] nums) {
        int count = 0;
        for(int i = nums.length - 2; i >=0; i--) {
                while (nums[i] > nums[i + 1]) {
                    int temp = greatestDivisor(nums[i]);
                    if (temp == 1) {
                        return -1;
                    }
                    nums[i] /= temp;
                    count++;
            }
        }
        return count;
    }

    public static int greatestDivisor(int x) {
        for(int i = (int) Math.sqrt(x); i > 1; i--) {
            if(x % i == 0) {
                return Math.max(i, x/i);
            }
        }
        return 1;
    }
}
