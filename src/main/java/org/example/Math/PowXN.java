package org.example.Math;

/*
50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

 */

public class PowXN {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE){
            if(x == 1.0 || x == -1.0){
                return (double) 1;
            }
            else{
                x = 1/x;
                n = Integer.MAX_VALUE;
            }
        }
        double answer = 1.0;
        long m = Math.abs((long)n);
        while(m > 0){
            if(m % 2 == 0){
                x = x*x;
                m = m/2;
            }
            if(m % 2 != 0){
                answer = x * answer;
                m = m - 1;
            }
        }
        if(n < 0){
            return (double) 1/answer;
        }
        if (n == Integer.MIN_VALUE) {
            answer *= 1 / x;
        }
        return answer;
    }
}
