package org.example.BinarySearch;

/*
74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 */

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int length = row * col;
        int start = 0, end = length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int number = matrix[mid/col][mid%col];
            if(number == target){
                return true;
            }
            else if(number > target){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return false;
    }
}
