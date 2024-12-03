package org.example.slidingWindow;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSumofAllKLongSubarraysI {
    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2,2,3,4,2,3};
        int nums1[] = new int[]{3,8,7,8,7,5};
        print(findXSum(nums, 6, 2));
        System.out.println();
        print(findXSum(nums1, 2,2));

    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int result[] = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++) {
            Map<Integer, Integer> frequency = new HashMap<>();
            for(int j = i; j < i + k; j++) {
                if(frequency.containsKey(nums[j])) {
                    int count = frequency.get(nums[j]);
                    frequency.put(nums[j], count + 1);
                }
                else {
                    frequency.put(nums[j], 1);
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

            for(Map.Entry<Integer, Integer> entry:frequency.entrySet()) {
                pq.add(new int[] {entry.getKey(), entry.getValue()});
            }

            int sum = 0;
            int count = 0;
            while (!pq.isEmpty() && count < x) {
                int req[] = pq.poll();
                sum = sum + req[0]*req[1];
                count++;
            }
            result[i] = sum;

        }
        return result;
    }

    public static void print(int nums[]) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
