package org.example.MultipleProbSols;

import java.util.*;

public class DivisibleByThree {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] {4,2,3,1}));
        System.out.println(maximumSum(new int[] {2,1,5}));
        System.out.println(maximumSum(new int[] {5,2,2,4}));
        System.out.println(minOperations(new int[] {3,8,3,6,5,8}));
        System.out.println(minOperations(new int[] {2,2}));
        System.out.println(minOperations(new int[] {4,3,5,1,2}));
        System.out.println(maximumScore(new int[] {2,1,5,2,3}, "01010"));
        System.out.println(maximumScore(new int[] {4,7,2,9}, "0000"));
        System.out.println(maximumScore(new int[] {4,3,5,1,2}, "11111"));
        System.out.println(mirrorDistance(25));
        System.out.println(mirrorDistance(10));
        System.out.println(mirrorDistance(7));
        System.out.println(minCost("aabaac", new int[] {1,2,3,4,1,10}));
        System.out.println(minCost("abc", new int[] {10,5,8}));
        System.out.println(minCost("zzzzz", new int[] {7,7,7,7,7}));
        System.out.println(minSwaps(new int[] {1,2,3}, new int[] {3,2,1}));
        System.out.println(minSwaps(new int[] {4,6,6,5}, new int[] {4,6,5,5}));
        System.out.println(minSwaps(new int[] {7,7}, new int[] {8,7}));
        System.out.println(minSwaps(new int[] {1,2}, new int[] {2,1}));

    }

    public static int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        List<Integer> same = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(nums[i] == forbidden[i]) {
                same.add(i);
            }
        }
        if(same.size() == 0) {
            return 0;
        }
        if(same.size() == 1) {
            int i = same.get(0);
            for(int j = 0; j < n; j++) {
                if(j != i && nums[j] != forbidden[i] && nums[i] != forbidden[j]) {
                    return 1;
                }
            }
            return -1;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i : same) {
            set.add(nums[i]);
        }
        if(set.size() == 1) {
            return -1;
        }
        return (same.size() - 1);
    }

    public static long minCost(String s, int[] cost) {
        long costT = 0;
        Map<Character, Long> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            costT = costT + cost[i];
            map.put(ch, map.getOrDefault(ch, 0L) + cost[i]);
        }
        long max = 0;
        for(long val : map.values()) {
            max = Math.max(max, val);
        }
        return (costT - max);
    }

    public static int mirrorDistance(int n) {
        int m = n;
        int result = 0;
        while(m > 0) {
            int temp = m%10;
            result = 10*result + temp;
            m = m/10;
        }
        return Math.abs(n-result);

    }

    public static long maximumScore(int[] nums, String s) {
        int n = nums.length;
        int max = 0;
        char[] array = s.toCharArray();
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && array[j] == '1' && array[j - 1] == '0') {
                array[j] = '0';
                array[j - 1] = '1';
                j--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] == '1') {
                max += nums[i];
            }
        }
        return max;
    }

    public static int minOperations(int[] nums) {
        int operation = 0;
        int n = nums.length;
        int start = 0;
        while(duplicate(nums, start, n)) {
            operation++;
            start = start + Math.min(3, n - start);
        }
        return operation;
    }

    public static boolean duplicate(int[] nums, int start, int n) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = start; i < n; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            else {
                set.add(nums[i]);
            }
        }
        return false;
    }


    public static int maximumSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int n : nums) {
            if(n % 3 == 0) {
                list.add(n);
            }
            else if(n % 3 == 1) {
                list1.add(n);
            }
            else {
                list2.add(n);
            }
        }
        list.sort(Collections.reverseOrder());
        list1.sort(Collections.reverseOrder());
        list2.sort(Collections.reverseOrder());

        int max = 0;

        if(list.size() >= 3) {
            max = Math.max(max, list.get(0) + list.get(1) + list.get(2));
        }
        if(list1.size() >= 3) {
            max = Math.max(max, list1.get(0) + list1.get(1) + list1.get(2));
        }
        if(list2.size() >= 3) {
            max = Math.max(max, list2.get(0) + list2.get(1) + list2.get(2));
        }
        if(!list.isEmpty() && !list1.isEmpty() && !list2.isEmpty()) {
            max = Math.max(max, list.get(0) + list1.get(0) + list2.get(0));
        }
        return max;



//	   Arrays.sort(nums);
//	   int n = nums.length;
//	   int max = 0;
//	   for(int i = n-1; i>=2; i--) {
//		   for(int j = i-1; j>=1; j--) {
//			   int sum = nums[j] + nums[i];
//			   int rem = (3 - (sum%3)) % 3;
//			   for(int k = j-1; k>=0; k--)
//				   if(nums[k] % 3 == rem) {
//					   max = Math.max(max, sum + nums[k]);
//					   break;
//				   }
//		   }
//	   }
//        return max;
    }
}
