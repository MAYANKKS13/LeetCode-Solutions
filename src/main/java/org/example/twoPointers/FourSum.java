package org.example.twoPointers;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));


    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();    /* for distinct entries */
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int third = j + 1;
                int fourth = nums.length - 1;
                while (third < fourth) {
                    int sum = nums[i] + nums[j] + nums[third] + nums[fourth];
                    if(sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[third]);
                        temp.add(nums[fourth]);

                        if(!set.contains(temp)) {
                            set.add(temp);
                        }
                        third++;
                        fourth--;
                    } else if (sum <= target) {
                        third++;
                    } else if (sum > target) {
                        fourth--;
                    }
                }
            }
        }
        for(List<Integer> list : set) {
            result.add(list);
        }
        return result;
    }
}
