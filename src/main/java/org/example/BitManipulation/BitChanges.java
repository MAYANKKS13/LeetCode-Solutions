package org.example.BitManipulation;

public class BitChanges {
    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
        System.out.println(minChanges(21, 21));
        System.out.println(minChanges(14, 13));

    }

    public static int minChanges(int n, int k) {
        String N = Integer.toBinaryString(n);
        String K = Integer.toBinaryString(k);
        int count = 0;
        char a, b;

        for (int i = 0; i < Math.max(N.length(), K.length()); i++) {
            if(i < N.length()) {
                a = N.charAt(N.length() - i -1);
            }
            else {
                a = '0';
            }
            if (i < K.length()) {
                b = K.charAt(K.length() - i - 1);
            }
            else {
                 b = '0';
            }

            if(a == '1' && b == '0') {
                count = count + 1;
            } else if (a == '0' && b == '1') {
                return -1;
            }
        }
        return count;

    }
}
