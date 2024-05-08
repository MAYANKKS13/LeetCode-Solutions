package org.example.HashMap;

/*
383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

 */

import java.util.Arrays;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        String new2 = mySort(ransomNote);
        String new1 = mySort(magazine);
        int j = 0;
        for(int i = 0; i < magazine.length(); i++){
            if(j < new2.length() && new2.charAt(j) == new1.charAt(i)){
                j++;
            }
        }
        if(j == ransomNote.length()){
            return true;
        }
        return false;
    }

    public String mySort(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);

    }
}
