package org.example.GameTheory;

public class StoneGame {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[] {1,5,2}));
        System.out.println(stoneGame(new int[] {1, 5, 233, 7}));
        System.out.println(stoneGame(new int[] {3, 7, 2, 3, 9, 8, 3, 6}));
        System.out.println(stoneGame(new int[] {3, 1}));
    }

    public static boolean stoneGame(int[] nums) {
        int i = 0, j = nums.length - 1;
        int num1 = 0, num2 = 0;
        boolean turn = true;
        while (i <= j) {
            int max = Math.max(nums[i], nums[j]);
            if (nums[i] >= nums[j]) {
                i++;
            } else {
                j--;
            }
            if (turn) {
                num1 = num1 + max;
            } else if (!turn) {
                num2 = num2 + max;
            }
        }
        return num1 > num2;
    }

}
