package org.example.arrayandStrings;

import java.util.PriorityQueue;

public class LongestHappyString {

    public static void main(String[] args) {
        LongestHappyString lB = new LongestHappyString();
        System.out.println(lB.longestDiverseString(1, 1, 7));
        System.out.println(lB.longestDiverseString(7, 1, 0));
        System.out.println(lB.longestDiverseString(0, 1, 3));
    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Count> heap = new PriorityQueue<>((x, y) -> y.count - x.count);
        String result = "";
        if(a > 0) {
            heap.offer(new Count(a, 'a'));
        }
        if(b > 0) {
            heap.offer(new Count(b, 'b'));
        }
        if(c > 0) {
            heap.offer(new Count(c, 'c'));
        }

        while (!heap.isEmpty()) {
            Count top = heap.poll();
            if (result.length() >= 2 && result.charAt(result.length() - 1) == top.letter && result.charAt(result.length() - 2) == top.letter) {
                if (heap.isEmpty()) {
                    break;
                }
                Count second = heap.poll();
                result = result + second.letter;
                second.count--;
                if(second.count > 0) {
                    heap.offer(second);
                }
                heap.offer(top);
            }
            else {
                result = result + top.letter;
                top.count--;
                if(top.count > 0) {
                    heap.offer(top);
                }
            }

        }
        return result;
    }

    class Count {
        int count;
        char letter;
        Count(int count, char letter) {
            this.count = count;
            this.letter = letter;
        }
    }

}
