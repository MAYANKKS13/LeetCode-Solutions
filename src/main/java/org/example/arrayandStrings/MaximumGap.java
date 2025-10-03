package org.example.arrayandStrings;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        int nums[] = new int[]{3,6,9,1};
        int nums1[] = new int[]{10};
        System.out.println(maximumGap(nums));
        System.out.println(maximumGap(nums1));

    }

    public static int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        sortArray(nums, 0, nums.length - 1);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i-1]);
        }
        return max;
    }

    public static void sortArray(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            sortArray(arr, l, m);
            sortArray(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int a = m - l + 1;
        int b = r - m;
        int[] left = new int[a];
        int[] right = new int[b];
        int p = 0;
        int q = 0;

        for (int i = 0; i < a; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < b; j++) {
            right[j] = arr[m + 1 + j];
        }
        int k = l;
        while (p < a && q < b) {
            if (left[p] < right[q]) {
                arr[k] = left[p];
                p++;
            } else {
                arr[k] = right[q];
                q++;
            }
            k++;
        }
        while (p < a) {
            arr[k] = left[p];
            p++;
            k++;
        }
        while (q < b) {
            arr[k] = right[q];
            q++;
            k++;
        }
    }
}
