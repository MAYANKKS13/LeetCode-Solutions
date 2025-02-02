package org.example.Heap;

import java.util.PriorityQueue;

public class MinimumLimitofBallsinaBag {
    public static void main(String[] args) {
        int nums[] = new  int[]{9}; int maxOperations = 2;
        int nums1[] = new int[]{2,4,8,2}; int maxOperations1 = 4;
        System.out.println(minimumSize(nums, maxOperations));
        System.out.println(minimumSize(nums1, maxOperations1));

    }

    public static int minimumSize(int[] nums, int maxOperations) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums) {
            heap.add(num);
        }

        while (maxOperations > 0) {
            int temp = heap.poll();
            int a = temp / 2;
            int b = temp - a;
            heap.add(a);
            heap.add(b);
            maxOperations--;
        }
        return heap.peek();
    }


}
