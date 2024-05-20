package org.example.arrayandStrings;

/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String first = strs[0];
        for(int i = 0; i < strs.length; i++){
            while(strs[i].indexOf(first) != 0){
                first = first.substring(0, first.length() - 1);
            }
        }
        return first;
    }

}
