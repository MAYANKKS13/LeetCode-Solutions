package org.example.BitManipulation;

/*
67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */

/*
This problem has been solved using BigInteger concept.
 */

import java.math.BigInteger;

public class AddBinary {
    public String addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger b1 = new BigInteger(b, 2);
        BigInteger add = a1.add(b1);
        String result = add.toString(2);
        return result;
    }
}
