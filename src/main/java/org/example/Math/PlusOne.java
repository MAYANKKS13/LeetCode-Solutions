package org.example.Math;

/*
66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int[] result = new int[n+1];
        int[] result1 = new int[n];

        int carry = 1;
        for(int i = n-1; i >= 0; i--) {
            result[i+1] = (digits[i] + carry)%10;
            result1[i] = (digits[i] + carry)%10;
            carry = (digits[i] + carry)/10;
        }
        if(carry > 0) {
            result[0] = carry;
        } else {
            return result1;
        }
        return result;
    }
}
