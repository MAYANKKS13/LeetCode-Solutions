package org.example.BitManipulation;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b){
        BigInteger add = new BigInteger(a, 2).add(new BigInteger(b, 2));
        return add.toString(2);
    }
}
