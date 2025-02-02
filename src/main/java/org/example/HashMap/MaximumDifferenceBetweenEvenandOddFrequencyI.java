package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaximumDifferenceBetweenEvenandOddFrequencyI {
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
        System.out.println(maxDifference("abcabcab"));

    }

    public static int maxDifference(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (char c : s.toCharArray()) {
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);

            if (freq % 2 == 0) {
                minEven = Math.min(minEven, freq);

            } else {
                maxOdd = Math.max(maxOdd, freq);

            }
        }

        return maxOdd - minEven;
    }

}
