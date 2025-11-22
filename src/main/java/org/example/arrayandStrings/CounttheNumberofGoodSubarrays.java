package org.example.arrayandStrings;

import java.util.HashMap;
import java.util.Map;

public class CounttheNumberofGoodSubarrays {
    public static void main (String[] args) {
        System.out.println(numGoodSubarrays(new int[] {1,2,3}, 3));
        System.out.println(numGoodSubarrays(new int[] {2,2,2,2,2,2}, 6));

    }

    public static long numGoodSubarrays(int[] nums, int k) {
        long count = 0;
        long sum = 0;
        Map<Long, Long> map = new HashMap<Long, Long>();
        map.put(0L, 1L);
        for(int num : nums) {
            sum = sum + num;
            long remainder = sum % k;
            count = count + map.getOrDefault(remainder, 0L);
            map.put(remainder, map.getOrDefault(remainder, 0L)+ 1);
        }
        return count;
    }

}
