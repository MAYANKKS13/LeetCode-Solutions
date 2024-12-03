package org.example.arrayandStrings;

import java.util.ArrayList;
import java.util.List;

public class SequenceofStringsAppearedontheScreen {
    public static void main(String[] args) {
        System.out.println(stringSequence("abc"));
        System.out.println(stringSequence("he"));

    }

    public static List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(char c : target.toCharArray()) {
            if(s.length() == 0 || s.length() < result.size()+1) {
                s.append('a');
                result.add(s.toString());
            }

            while (s.charAt(s.length() - 1) != c) {
                s.setCharAt(s.length() - 1, (char) ((char) s.charAt(s.length() - 1) + 1));
                result.add(s.toString());

            }
        }
        return result;

    }
}
