package org.example.arrayandStrings;

public class ScoreofaString {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = "zaz";
        System.out.println(score(s));
        System.out.println(score(s1));
        System.out.println((int)s.charAt(1));

    }

    public static int score(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++){
            sum = sum + Math.abs((int)s.charAt(i) - (int)s.charAt(i + 1));
        }
        return sum;
    }
}
