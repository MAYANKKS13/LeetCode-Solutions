package org.example.arrayandStrings;

import java.util.Arrays;

public class PermutationinString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));

    }

    public static boolean checkInclusion(String s1, String s2) {
        int a = s1.length();
        int b = s2.length();
        if(a > b) {
            return false;
        }
        char s1Sorted[] = s1.toCharArray();
        Arrays.sort(s1Sorted);
        for(int i = 0; i < b - a; i++) {
            String s2Temp = s2.substring(i, i + a);
            char s2Sorted[] = s2Temp.toCharArray();
            Arrays.sort(s2Sorted);
            if(Arrays.equals(s1Sorted, s2Sorted)) {
                return true;
            }
        }
        return false;

    }
}
