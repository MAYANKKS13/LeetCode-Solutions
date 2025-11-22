package org.example.arrayandStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubarray1 {
    public static void main (String[] args) {
        System.out.println(longestBalanced(new int[] {2,5,4,3}));
        System.out.println(longestBalanced(new int[] {3,2,2,5,4}));
        System.out.println(longestBalanced(new int[] {1,2,3,2}));
    }

    public static int longestBalanced(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> even = new HashSet<Integer>();
            Set<Integer> odd = new HashSet<Integer>();
            for(int j = i; j < nums.length; j++) {
                (nums[j] % 2 == 0 ? even : odd).add(nums[j]);
                if(even.size() == odd.size()) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

}
