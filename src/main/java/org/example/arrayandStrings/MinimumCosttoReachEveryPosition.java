package org.example.arrayandStrings;

public class MinimumCosttoReachEveryPosition {
    public static void main(String[] args) {
        int cost[] = new int[]{5,3,4,1,3,2};
        int cost1[] = new int[]{1, 2, 4, 6, 7};
        showArray(minCosts(cost));
        showArray(minCosts(cost1));

    }

    public static int[] minCosts(int[] cost) {
        int result[] = new int[cost.length];
        result[0] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            if(cost[i] < result[i-1]) {
                result[i] = cost[i];
            }
            else {
                result[i] = result[i-1];
            }
        }
        return result;
    }

    public static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
