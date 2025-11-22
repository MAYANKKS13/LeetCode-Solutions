package org.example.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumAlternatingSumofSquares {
    public static void main (String[] args) {
        System.out.println(maxAlternatingSum(new int[] {1,2,3}));
        System.out.println(maxAlternatingSum(new int[] {1, -1, 2, -2, 3, -3}));
    }

    public static long maxAlternatingSum(int[] nums) {
        long sumEven = 0;
        long sumOdd = 0;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num : nums) {
            pq.add(Math.abs(num));
        }
        int i = (n % 2 == 0) ? n/2 : (n/2) + 1;
        int j = (n - i);
        for(int k = 1; k <= i; k++) {
            int temp = pq.poll();
            sumEven = sumEven + (temp * temp);
        }
        for(int l = 1; l <= j; l++) {
            int temp1 = pq.poll();
            sumOdd = sumOdd + (temp1 * temp1);
        }
        return (sumEven - sumOdd);
    }

}
