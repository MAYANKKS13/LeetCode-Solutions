package org.example.slidingWindow;

/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        int n= s.length();
        int i = 0, j = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        while(j < n){
            if(map.containsKey(s.charAt(j))){
                int count = map.get(s.charAt(j));
                map.put(s.charAt(j), count + 1);
            }
            else {
                map.put(s.charAt(j), 1);
            }

            if(map.size() == (j-i+1)){
                length = Math.max(length, j-i+1);
                j++;
            }
            else if(map.size()< (j-i+1)){
                while(map.size()< (j-i+1)){
                    if(map.containsKey(s.charAt(i))){
                        if(map.get(s.charAt(i)) == 1){
                            map.remove(s.charAt(i));
                        }
                        else{
                            map.put(s.charAt(i), map.get(s.charAt(i))-1);
                        }
                    }
                    i++;
                }
                j++;
            }
        }
        return length;
    }
}
