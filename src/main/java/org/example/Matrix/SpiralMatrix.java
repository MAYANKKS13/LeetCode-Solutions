package org.example.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(spiral(matrix));
        System.out.println(spiral(matrix1));

    }

    public static List<Integer> spiral(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int n = matrix[0].length;
        int x = 0, y = 0, z = 1;
        List<Integer> list = new ArrayList<>();
        for(int k = 0; k <= rows/2 && k <= columns/2; k++){
            for(int i = y; i < columns - y; i++){
                list.add(matrix[x][i]);
            }
            for(int j = x + 1; j < rows -x - 1; j++){
                list.add(matrix[j][columns - y - 1]);
            }
            if(rows - x - 1 > x) {
                for (int i = columns - y - 1; i >= y; i--) {
                    list.add(matrix[rows - x - 1][i]);
                }
            }
            if(columns - y - 1 > y) {
                for (int j = rows - x - 2; j > x; j--) {
                    list.add(matrix[j][y]);
                }
            }
            x++;
            y++;
        }
        return list;
    }
}
