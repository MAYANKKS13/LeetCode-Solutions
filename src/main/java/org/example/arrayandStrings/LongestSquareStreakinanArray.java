package org.example.arrayandStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakinanArray {
    public static void main(String[] args) {
        int nums[] = new int[]{4,3,6,16,8,2};
        int nums1[] = new int[]{2,3,5,6,7};
        System.out.println(longestSquareStreak(nums));
        System.out.println(longestSquareStreak(nums1));

    }

    public static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for(int num : nums) {
            set.add(num);
        }
        for(int num : nums) {
            int temp = num;
            int count = 1;
            while (set.contains(temp*temp)) {
                temp = temp * temp;
                count++;
            }
            if(count >= 2) {
                max = Math.max(count, max);
            }
        }
        return max;

    }

}
