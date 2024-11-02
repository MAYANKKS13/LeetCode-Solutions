package org.example.BitManipulation;

import java.util.Arrays;

public class MaximumPossibleNumberbyBinaryConcatenation {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3};
        int nums1[] = new int[]{2,8,16};
        System.out.println(maxGoodNumber(nums));
        System.out.println(maxGoodNumber(nums1));

    }

    public static int maxGoodNumber(int[] nums) {

        String convertToBinary[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            convertToBinary[i] = Integer.toBinaryString(nums[i]);
        }
        Arrays.sort(convertToBinary, (a, b) -> (b + a).compareTo(a + b));

        String result = "";
        for(String temp : convertToBinary) {
            result = result + temp;
        }
        int convertToInteger = Integer.parseInt(result, 2);
        return convertToInteger;

    }


}
