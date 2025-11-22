package org.example.Math;

public class MinimumTimetoMakeRopeColorful {
    public static void main (String[] args) {
        System.out.println(minCost("abaac", new int[] {1,2,3,4,5}));
        System.out.println(minCost("abc", new int[] {1,2,3}));
        System.out.println(minCost("aabaa", new int[] {1,2,3,4,1}));
        System.out.println(minCost("aaabbbabbbb", new int[] {3,5,10,7,5,3,5,5,4,8,1}));
    }

    public static int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int n = neededTime.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++) {
            if(colors.charAt(i) == colors.charAt(i+1)) {
                min = Math.min(neededTime[i], neededTime[i+1]);
                cost = cost + min;
                neededTime[i+1] = Math.max(neededTime[i], neededTime[i+1]);
            }
        }
        return cost;
    }

}
