package org.example.arrayandStrings;

import java.util.*;

public class FindMissingNumbersinaRange {
    public static void main (String[] args) {
        System.out.println(findMissingElements(new int[] {1,4,2,5}));
        System.out.println(findMissingElements(new int[] {7,8,6,9}));
        System.out.println(findMissingElements(new int[] {5,1}));
        System.out.println(findMissingElements(new int[] {5,1}));
    }

    public static List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums) {
            set.add(num);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = min; i <= max; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

}
