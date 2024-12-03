package org.example.arrayandStrings;

public class SeparateBlackandWhiteBalls {
    public static void main(String[] args) {
        String s = "101";
        String s1 = "100";
        String s2 = "0111";
        System.out.println(minimumSteps(s));
        System.out.println(minimumSteps(s1));
        System.out.println(minimumSteps(s2));

    }

    public static long minimumSteps(String s) {
        long count = 0;
        long counter = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else if (s.charAt(i) == '0') {
                counter += count;
            }
        }
        return counter;

    }

}
