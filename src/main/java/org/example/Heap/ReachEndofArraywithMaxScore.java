package org.example.Heap;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReachEndofArraywithMaxScore {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 3, 1, 3, 2);
        System.out.println(maxScore(nums));

    }

    public static long maxScore(List<Integer> nums) {
        int n = nums.size();
        long result[] = new long[n];
        Deque<Integer> deque= new LinkedList<>();

        deque.offer(0);
        result[0] = 0;

        for(int i= 1; i < n; i++) {
            int next = deque.peekFirst();
            result[i] = result[next] + (i - next)*nums.get(next);

            while (!deque.isEmpty() && (result[deque.peekLast()] + (deque.peekLast() - next)*nums.get(deque.peekLast()) <= result[i] + (i - next)*nums.get(i))) {
                deque.pollLast();
            }
            deque.offer(i);

        }
        return result[n - 1];
    }
}
