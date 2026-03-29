package org.example.MultipleProbSols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenateNonZero {
    public static void main(String[] args) {
        System.out.println(sumAndMultiply(10203004));
        System.out.println(sumAndMultiply(1000));
        System.out.println(maxBalancedSubarray(new int[] {3,1,3,2,0}));
        System.out.println(maxBalancedSubarray(new int[] {3,2,8,5,4,14,9,15}));
        System.out.println(maxBalancedSubarray(new int[] {0}));
        System.out.println(maxSumDivThree(new int[] {3,6,5,1,8}));
        System.out.println(maxSumDivThree(new int[] {4}));
        System.out.println(maxSumDivThree(new int[] {1,2,3,4,4}));
        System.out.println(prefixesDivBy5(new int[] {0,1,1}));
        System.out.println(prefixesDivBy5(new int[] {1,1,1}));

    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<Boolean>();
        int temp = 0;
        for(int num : nums) {
            temp = ((2 * temp) + num) % 5;
            result.add(temp == 0);
        }
        return result;
    }

    public static int maxSumDivThree(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        int temp[] = new int[max+1];
        for(int num:nums) {
            temp[num]++;
        }
        int index = 0;
        for(int i = 0; i <= max; i++) {
            while(temp[i] > 0) {
                nums[index++] = i;
                temp[i]--;
            }
        }
        for(int i = 0; i < n; i++) {
            if(sum % 3 == 0) {
                break;
            }
            sum = sum - nums[i];
        }
        return sum;
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {
        int n = queries.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            arr[i] = sumAndMultiplyHelper(s, left, right);
        }
        return arr;
    }

    public static int sumAndMultiplyHelper(String string, int left, int right) {
        long temp = 0;
        long sum = 0;
        for(int i = left; i < right; i++) {
            char c = string.charAt(i);
            if(c != 0) {
                int digit = c - '0';
                temp = ((temp * 10)+digit) % 1_000_000_007;
                sum = (sum + digit) % 1_000_000_007;
            }
        }
        if(temp == 0) {
            return 0;
        }
        return (int)((temp * sum)  % 1_000_000_007);
    }

    public static int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        int length = 0, xOR = 0;
        int isEven = 0, isOdd = 0, temp = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("0!0", -1);
        for(int i = 0; i < n; i++) {
            xOR = xOR ^ nums[i];
            if(nums[i] % 2 ==0) {
                isEven++;
            }
            else {
                isOdd++;
            }
            temp = isEven - isOdd;
            String s = xOR + "!" + temp;
            if(map.containsKey(s)) {
                length = Math.max(length, i - map.get(s));
            }
            else {
                map.put(s, i);
            }
        }
        return length;
    }


    public static long sumAndMultiply(int n) {
        StringBuilder s = new StringBuilder();
        String s1 = String.valueOf(n);
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != '0') {
                s.append(s1.charAt(i));
            }
        }
        if(s.length() == 0) {
            return 0;
        }
        long temp = Long.parseLong(s.toString());
        long sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum = sum + (s.charAt(i) - '0');
        }
        return (temp * sum);
    }
}
