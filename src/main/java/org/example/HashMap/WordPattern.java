package org.example.HashMap;

/*
290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

 */

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length){
            return false;
        }
        Map<String, String> map = new HashMap();
        for(int i = 0; i < str.length; i++){
            if(map.containsKey(pattern.charAt(i) + "")){
                if(!map.get(pattern.charAt(i) + "").equals(str[i]+"a")){
                    return false;
                }
            }
            else{
                if(map.containsKey(str[i]+"a")) {
                    return false;
                }
                map.put(pattern.charAt(i) + "", str[i]+"a");
                map.put(str[i]+"a", pattern.charAt(i) + "");
            }
        }
        return true;
    }
}
