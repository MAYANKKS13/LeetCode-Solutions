package org.example.MultipleProbSols;

import java.util.Arrays;

public class AbsDifference {
    public static void main(String[] args) {
        AbsDifference abs = new AbsDifference();
        System.out.println(abs.absDifference(new int[] {5,2,2,4}, 2));
        System.out.println(abs.absDifference(new int[] {100}, 1));
        System.out.println(reverseWords("cat and mice"));
        System.out.println(reverseWords("banana healthy"));
        System.out.println(reverseWords("book is nice"));
        System.out.println(abs.minMoves(new int[] {5,1,-4}));
        System.out.println(abs.minMoves(new int[] {1,2,-5,2}));
        System.out.println(minDeletionSize(new String[] {"cba","daf","ghi"}));
        System.out.println(minDeletionSize(new String[] {"a","b"}));
        System.out.println(minDeletionSize(new String[] {"zyx","wvu","tsr"}));

    }

    public static int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 0; j < strs.length-1; j++) {
                if(strs[j].charAt(i) > strs[j+1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public long minMoves(int[] balance) {
        int negative = 0;
        int idx = 0;
        int n = balance.length;
        int count = 0, total = 0;
        for(int i = 0; i < n; i++) {
            if(balance[i] < 0) {
                idx = i;
                break;
            }
        }
        for(int b : balance) {
            if(b > 0) {
                total = total + b;
            }
        }
        if(total < -balance[idx]) {
            return -1;
        }




        int left = idx == 0 ? n-1 : idx-1;
        int right = idx == n-1 ? 0 : idx+1;
        if(balance[left] + balance[right] >= Math.abs(negative)) {
            count = Math.abs(negative);
        }




        return count;
    }

    public static String reverseWords(String s) {
        String[] arrStr = s.split(" ");
        int vowelFirst = countVowel(arrStr[0]);
        for(int i = 1; i < arrStr.length; i++) {
            if(countVowel(arrStr[i]) == vowelFirst) {
                StringBuilder temp = new StringBuilder(arrStr[i]);
                temp.reverse();
                arrStr[i] = temp.toString();
            }
        }
        return String.join(" ", arrStr);
    }

    public static int countVowel(String s1) {
        int count = 0;
        for(char c : s1.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int maxSum = 0, minSum = 0;
        for(int i = 0; i < k; i++) {
            minSum = minSum + nums[i];
        }
        for(int i = n; i >= n-k+1; i--) {
            maxSum = maxSum + nums[i];
        }
        return Math.abs(maxSum-minSum);
    }
}
