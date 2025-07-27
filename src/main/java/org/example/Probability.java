package org.example;

import java.util.*;

public class Probability {
    public static void main(String[] args) {
        int[] coin = {0, 1};
        System.out.println("------Tossing Coin Probability------");
//        find_probability(1000, coin);
        System.out.println();
        System.out.println();
        int[] dice = {1, 2, 3, 4, 5, 6};
        System.out.println("------Rolling Dice Probability------");
        find_probability(10000, dice);
        System.out.println();
        System.out.println();
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println("------Drawing Cards Probability------");
//        find_probability(1000, cards);
    }

    public static void find_probability(int trial, int[] array) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < trial; i++) {
            list.add(array[random.nextInt(array.length)]);
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for(int k : list) {
            frequency.put(k, Collections.frequency(list, k));
        }
        for(int outcome : array) {
            System.out.printf("Probability of getting %d is %.3f%n", outcome,
                    (double)(frequency.getOrDefault(outcome, 0))/trial);
        }

    }
    
}
