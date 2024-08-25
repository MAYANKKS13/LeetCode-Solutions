package org.example.Math;

/*
149. Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:

Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        int max = 0;
        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> map = new HashMap<>();
            int countSlopes = 1;
            for(int j = i + 1; j < points.length; j++){
                double slope;
                if(points[j][0] - points[i][0] != 0){
                    slope = ((double) points[j][1] - points[i][1])/((double) points[j][0] - points[i][0]);
                }
                else {
                    slope = Double.MAX_VALUE;
                }
                if(slope == -0.0){
                    slope = 0.0;
                }
                if(map.containsKey(slope)){
                    countSlopes = map.get(slope) + 1;
                    map.put(slope, countSlopes);
                }
                else {
                    countSlopes = 1;
                    map.put(slope, countSlopes);
                }
                max = Math.max(max, countSlopes + 1);
            }
        }
        return max;
    }
}
