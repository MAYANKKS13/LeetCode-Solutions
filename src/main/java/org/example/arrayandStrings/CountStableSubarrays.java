package org.example.arrayandStrings;

public class CountStableSubarrays {
    public static void main (String[] args) {
        System.out.println(countStableSubarrays(new int[] {9,3,3,3,9}));
        System.out.println(countStableSubarrays(new int[] {1,2,3,4,5}));
        System.out.println(countStableSubarrays(new int[] {-4,4,0,0,-8,-4}));
    }

    public static long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        int count = 0;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + capacity[i];
        }
        for (int l = 0; l < n - 2; l++) {
            for (int r = l + 2; r < n; r++) {
                long middleSum = prefixSum[r] - prefixSum[l + 1];
                if (capacity[l] == middleSum && capacity[r] == middleSum) {
                    count++;
                }
            }
        }
        return count;
    }

}
