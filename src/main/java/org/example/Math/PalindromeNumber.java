package org.example.Math;

/*
9. Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }

        int m=x;
        int res=0;
        while (m>0){
            int y = m%10;
            res = 10*res + y;
            m = m/10;
        }

        if(res==x){
            return true;
        }

        else{
            return false;
        }
    }
}
