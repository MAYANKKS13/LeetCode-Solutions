package org.example.MultipleProbSols;

import java.util.HashMap;
import java.util.Map;

public class PreSum {
    //	private int[][] matrix;

    public static void main(String[] args) {
//		show(runningSum(new int[] {1,2,3,4}));
//		show(runningSum(new int[] {1,1,1,1,1}));
//		show(runningSum(new int[] {3,1,2,10,1}));
//		System.out.println();
//		System.out.println(subarraySum(new int[] {1,1,1}, 2));
//		System.out.println(subarraySum(new int[] {1,2,3}, 3));
        System.out.println(sumRegion(new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}, 1,1,2,2));

    }

    public static int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
        int sum = 0;
        int preMatrix[][] = prefixMatrix(matrix);
        sum = preMatrix[row2][col2];
        if(row1 > 0) {
            sum -= preMatrix[row1-1][col2];
        }
        if(col1 > 0) {
            sum -= preMatrix[row2][col1 - 1];
        }
        if(row1 > 0 && col1 > 0) {
            sum += preMatrix[row1-1][col1-1];
        }
        return sum;
    }

    public static int[][] prefixMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int prefixMatrix[][] = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                prefixMatrix[i][j] = matrix[i][j];
                if(i > 0) {
                    prefixMatrix[i][j] += prefixMatrix[i-1][j];
                }
                if(j > 0) {
                    prefixMatrix[i][j] += prefixMatrix[i][j-1];
                }
                if(i > 0 && j > 0) {
                    prefixMatrix[i][j] -= prefixMatrix[i-1][j-1];
                }
            }
        }
        return prefixMatrix;
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for(int n : nums) {
            sum = sum + n;
            if(map.containsKey(sum-k)) {
                count = count + map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    public static int[] runningSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        return prefix;
    }

    public static void show(int[] arr) {
        for(int a : arr) {
            System.out.print(a + " ");
        }
    }
}
