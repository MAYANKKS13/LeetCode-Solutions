package org.example.arrayandStrings;

/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int answer = 0;
        int left = 0, right = 0;
        while(start <= end){
            if(height[start] <= height[end]){
                if(height[start] >= left){
                    left = height[start];
                }
                else{
                    answer = answer + (left - height[start]);
                }
                start++;
            }
            else{
                if(height[end] >= right){
                    right = height[end];
                }
                else{
                    answer = answer + (right - height[end]);
                }
                end--;
            }
        }
        return answer;
    }
}
