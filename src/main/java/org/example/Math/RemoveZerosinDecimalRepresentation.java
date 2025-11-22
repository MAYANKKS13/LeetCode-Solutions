package org.example.Math;

public class RemoveZerosinDecimalRepresentation {
    public static void main (String[] args) {
        System.out.println(removeZeros(1020030));
        System.out.println(removeZeros(1));
        System.out.println(removeZeros(20));
    }

    public static long removeZeros(long n) {
        String s = String.valueOf(n);
        StringBuilder s1 = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                s1.append(s.charAt(i));
            }
        }
        return Integer.valueOf(s1.toString());
    }

}
