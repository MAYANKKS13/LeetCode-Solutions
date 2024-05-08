package org.example.HashMap;

/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

This solution contains two ways of solving the problem
 */

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] array = new int[256];
        for(int i = 0 ; i < s.length(); i++) {
            array[s.charAt(i)]++;
            array[t.charAt(i)]--;
        }
        for(int i = 0 ; i < 256; i++) {
            if(array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] arr = s.toCharArray();
        char[] arr1 = t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        for(int i = 0; i<s.length(); i++){
            if(arr[i]!=arr1[i]){
                return false;
            }
        }
        return true;
    }
}
