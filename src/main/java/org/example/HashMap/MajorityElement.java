package org.example.HashMap;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3};
        int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {1,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));

    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int size = nums.length;
        int n = (int) Math.floor(size/3);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < size; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        Set<Integer> set = map.keySet();
        for(int key : set) {
            if(map.get(key) > n) {
                list.add(key);
            }
        }
        return list;
    }
}
