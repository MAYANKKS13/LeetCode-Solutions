package org.example.MultipleProbSols;

import java.util.Arrays;

public class TotalWaviness {
    public static void main(String[] args) {
//		System.out.println(totalWaviness(120, 130));
//		System.out.println(totalWaviness(198, 202));
//		System.out.println(totalWaviness(4848, 4848));
//		System.out.println(minimumFlips(7));
//		System.out.println(minimumFlips(10));
//		show(lexSmallestNegatedPerm(3, 0));
//		show(lexSmallestNegatedPerm(1, 10000000000L));
//		System.out.println(countPartitions(new int[] {10,10,3,7,6}));
//		System.out.println(countPartitions(new int[] {1,2,2}));
//		System.out.println(countPartitions(new int[] {2,4,6,8}));
//		System.out.println(countCollisions("RLRSLL"));
//		System.out.println(countCollisions("LLRR"));
        System.out.println(areSimilar(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 4));
        System.out.println(areSimilar(new int[][] {{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2));
        System.out.println(areSimilar(new int[][] {{2,2},{2,2}}, 3));

    }

    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int s = k%n;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i % 2 == 0 && mat[i][j] != mat[i][(j+s)%n]) {
                    return false;
                }
                else {
                    if(mat[i][j] != mat[i][(j-s+n)%n]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int countCollisions(String directions) {
        int count = 0;
        int n = directions.length();

        int left = 0;
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }
        int right = n-1;
        while(right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                count++;
            }
        }
        return count;
    }

    public static int countPartitions(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int num : nums) {
            sum = sum + num;
        }
        int tempSum = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            tempSum = tempSum + nums[i];
            if((tempSum % 2 == 0 && (sum-tempSum) % 2 == 0) || (tempSum % 2 != 0 && (sum-tempSum) % 2 != 0)) {
                count++;
            }
        }
        return count;
    }

    public static int[] lexSmallestNegatedPerm(int n, long target) {
        long total = (n*(n+1))/2;
        long temp  = total - target;
        long temp1 = temp/2;
        if(target > total || target < -total) {
            return new int[0];
        }
        boolean[] bool = new boolean[n+1];
        for(int i = n; i >=1 && temp1 > 0; i--) {
            if(i <= temp1) {
                bool[i] = true;
                temp1 = temp1 - i;
            }
        }
        if(temp1 != 0) {
            return new int[0];
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = bool[i+1] ? -(i+1) : (i+1);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void show(int[] arr) {
        for(int i = 0; i< arr.length; i++) {
            System.out.println(arr[i] + " ");
            System.out.println();
        }
    }

    public static int minimumFlips(int n) {
        int flips = 0;
        String s = Integer.toBinaryString(n);
        String s1 = new StringBuilder(s).reverse().toString();
        for(int i = 0; i < s1.length(); i++) {
            if(s.charAt(i) != s1.charAt(i)) {
                flips++;
            }
        }
        return flips;
    }

    public static int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1; i <= num2; i++) {
            String s = String.valueOf(i);
            char[] c = s.toCharArray();
            if(s.length() < 3) {
                continue;
            }
            for(int j = 1; j < c.length - 1; j++) {
                if((c[j-1] - '0') < (c[j] - '0') && (c[j] - '0') > (c[j+1] - '0')) {
                    count++;
                }
                else if((c[j-1] - '0') > (c[j] - '0') && (c[j] - '0') < (c[j+1] - '0')) {
                    count++;
                }
            }
        }
        return count;
    }
}
