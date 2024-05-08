package org.example.Math;

/*
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int five = 5;
        int count = 0;
        while(five <= n){
            count += (n/five);
            five = five*5;
        }
        return count;
    }
}
