package org.example.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    public static void main(String[] args) {
        int nums[] = new int[]{10,10,10,10,10};
        int nums1[] = new int[]{1,10,3,3,3};
        int nums2[] = new int[]{672579538,806947365,854095676,815137524};
        System.out.println(maxKelements(nums, 5));
        System.out.println(maxKelements(nums1, 3));
        System.out.println(maxKelements(nums2, 3));

    }

    public static long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
            queue.add((long) nums[i]);
        }
        while(k > 0) {
            long temp = queue.poll();
            score = score + temp;
            queue.add((long)Math.ceil(temp/3.0));
            k--;
        }
        return score;

    }


}
