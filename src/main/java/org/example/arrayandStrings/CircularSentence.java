package org.example.arrayandStrings;

public class CircularSentence {
    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        String sentence1 = "eetcode";
        String sentence2 = "Leetcode is cool";
        System.out.println(isCircularSentence(sentence));
        System.out.println(isCircularSentence(sentence1));
        System.out.println(isCircularSentence(sentence2));

    }

    public static boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(n - 1)) {
            return false;
        }
        for(int i = 1; i < n - 1; i++) {
            if(sentence.charAt(i) == ' ' && (sentence.charAt(i - 1) != sentence.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
