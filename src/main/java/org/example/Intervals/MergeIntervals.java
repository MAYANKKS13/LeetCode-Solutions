package org.example.Intervals;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals1 = {{1, 4}, {4, 5}};
        print2D(merge(intervals));
        System.out.println();
        print2D(merge(intervals1));

    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[0] == entry2[0]) {
                    return 0;
                }
                else if (entry1[0] > entry2[0]) {
                    return 1;
                }
                return  -1;
            }
        });

        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            }
            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
    
    public static void print2D(int[][] array) {
        for (int[] arr:array) {
            System.out.print(Arrays.toString(arr) + ",");
        }
    }

}
