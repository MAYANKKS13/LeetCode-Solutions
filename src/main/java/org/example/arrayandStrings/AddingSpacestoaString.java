package org.example.arrayandStrings;

public class AddingSpacestoaString {
    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int spaces[] = new int[]{8,13,15};
        String s1 = "icodeinpython";
        int spaces1[] = new int[]{1,5,7,9};
        String s2 = "spacing";
        int spaces2[] = new int[]{0,1,2,3,4,5,6};
        System.out.println(addSpaces(s, spaces));
        System.out.println(addSpaces(s1, spaces1));
        System.out.println(addSpaces(s2, spaces2));

    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder result =new StringBuilder();
        int j = 0;
        int k = 0;

        for(int i = 0; i < s.length(); i++) {
            if(j < spaces.length && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
