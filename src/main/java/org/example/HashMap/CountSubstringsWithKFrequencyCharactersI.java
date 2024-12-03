package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringsWithKFrequencyCharactersI {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abacb", 2));
        System.out.println(numberOfSubstrings("abcde", 1));

    }

    public static int numberOfSubstrings(String s, int k) {
        int count = 0;
        for(int i = 0 ; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if(map.containsKey(c)) {
                    int temp = map.get(c);
                    map.put(c, temp+1);
                }
                else {
                    map.put(c, 1);
                }

                if(check(map, k)) {
                    count = count + 1;
                }
            }

        }
        return count;
    }

    public static boolean check(Map<Character, Integer> map, int k){
        for(int i : map.values()) {
            if(i >= k) {
                return true;
            }
        }
        return false;
    }
}
