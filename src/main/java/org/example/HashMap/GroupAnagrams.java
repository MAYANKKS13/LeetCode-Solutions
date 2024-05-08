package org.example.HashMap;

/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]
 */

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(mySort(strs[i]))) {
                map.put(mySort(strs[i]), new ArrayList<>());
            }
            map.get(mySort(strs[i])).add(strs[i]);
        }
        return new ArrayList<>(map.values());  //reduced by 1 ms

        // List<List<String>> list = new ArrayList<>();
        // for(List<String> temp : map.values()){
        //     list.add(temp);
        // }
        // return list;
    }

    public String mySort(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);

    }
}
