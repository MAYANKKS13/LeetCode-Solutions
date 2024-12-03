package org.example.BitManipulation;


public class FindKthBitinNthBinaryString {
    public static void main(String[] args) {
        System.out.println(findKthBit(3,1));
        System.out.println(findKthBit(4,11));

    }

    public static char findKthBit(int n, int k) {
        return findKthBitHelper(n).charAt(k-1);

    }

    public static String findKthBitHelper(int n) {
        if(n == 1) {
            return "0";
        }
        return findKthBitHelper(n-1) + "1" + reverse(findKthBitHelper(n-1));


    }
    public static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '0'){
                result.append('1');
            }
            else {
                result.append('0');
            }
        }
        return result.reverse().toString();
    }
}
