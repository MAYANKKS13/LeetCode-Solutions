package org.example.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));

    }

    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        while(!pq.isEmpty()) {
            int value = pq.peek().getValue();
            char c = pq.poll().getKey();
            for(int i = 0; i < value; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
