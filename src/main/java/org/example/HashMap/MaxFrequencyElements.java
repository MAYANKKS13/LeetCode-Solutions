package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyElements {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[] {1,5,2}));
        System.out.println(maxFrequencyElements(new int[] {1, 5, 233, 7}));
        System.out.println(maxFrequencyElements(new int[] {3, 7, 2, 3, 9, 8, 2, 6}));
        System.out.println(maxFrequencyElements(new int[] {3, 1}));
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int MAX_VALUE = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        for(int i : map.values()) {
            if(i > MAX_VALUE) {
                MAX_VALUE = i;
            }
        }
        int total = 0;
        for(int i : map.values()) {
            if(i == MAX_VALUE) {
                total = total + i;
            }
        }
        return total;

    }
}
