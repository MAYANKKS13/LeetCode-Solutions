package org.example.BitManipulation;

public class SmallestNumberWithAllSetBits {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(10));
        System.out.println(smallestNumber(3));

    }

    public static int smallestNumber(int n) {
        int k = (int)(Math.floor(Math.log(n)/Math.log(2))) + 1;
        return ((1 << (k)) - 1);

    }
}
