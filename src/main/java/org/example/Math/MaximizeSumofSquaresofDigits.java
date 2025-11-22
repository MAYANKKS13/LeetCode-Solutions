package org.example.Math;

public class MaximizeSumofSquaresofDigits {
    public static void main (String[] args) {
        System.out.println(maxSumOfSquares(2, 3));
        System.out.println(maxSumOfSquares(2, 17));
        System.out.println(maxSumOfSquares(1, 10));
    }

    public static String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        int temp = sum;
        for(int i = 0; i < num; i++) {
            int digit = Math.min(temp, 9);
            s.append(digit);
            temp = temp - digit;
        }
        return s.toString();
    }

}
