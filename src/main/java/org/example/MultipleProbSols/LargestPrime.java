package org.example.MultipleProbSols;

import java.util.*;

public class LargestPrime {
    public static void main(String[] args) {
//		System.out.println(largestPrime(20));
//		System.out.println(largestPrime(2));
//		show(sortByReflection(new int[] {4,5,4}));
//		System.out.println();
//		show(sortByReflection(new int[] {3,6,5,8}));
//		System.out.println(countTriples(5));
//		System.out.println(countTriples(10));
//		System.out.println(countTriples(250));
//		show(plusOne(new int[] {1,2,3}));
//		show(plusOne(new int[] {4,3,2,1}));
//		show(plusOne(new int[] {9,9}));
//		System.out.println(maximum69Number(9669));
//		System.out.println(maximum69Number(9996));
//		System.out.println(maximum69Number(9999));
//		System.out.println(maximumScore(new int[] {10,-1,3,-4,-5}));
//		System.out.println(maximumScore(new int[] {-7,-5,3}));
//		System.out.println(maximumScore(new int[] {1,1}));
//		System.out.println(reversePrefix("abcd", 2));
//		System.out.println(reversePrefix("xyz", 3));
//		System.out.println(reversePrefix("hey", 1));
//		System.out.println(largestEven("1112"));
//		System.out.println(largestEven("221"));
//		System.out.println(largestEven("1"));
//		System.out.println(wordSquares(new String[] {"able","area","echo","also"}));
//		System.out.println(wordSquares(new String[] {"code","cafe","eden","edge"}));
//		System.out.println(sumFourDivisors(new int[] {21,4,7}));
//		System.out.println(sumFourDivisors(new int[] {21,21}));
//		System.out.println(sumFourDivisors(new int[] {1,2,3,4,5}));
        System.out.println(uniqueMorseRepresentations(new String[] {"gin","zen","gig","msg"}));
        System.out.println(uniqueMorseRepresentations(new String[] {"a"}));

    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseStrings = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Character, String> map = new HashMap<Character, String>();
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, morseStrings[i]);
            i++;
        }
        List<String> list = new ArrayList<String>();
        for(String s : words) {
            String temp = "";
            for(int j = 0; j < s.length(); j++) {
                temp = temp + map.get(s.charAt(j));
            }
            list.add(temp);
        }
        Set<String> set = new HashSet<String>();
        for(String s1 : list) {
            set.add(s1);
        }
        return set.size();
    }

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum = sum + div4Sum(n);
        }
        return sum;
    }

    public static int div4Sum(int n) {
        int count = 0;
        int tempSum = 0;
        for(int i = 1; i*i <=n; i++) {
            if(n % i == 0) {
                count++;
                tempSum = tempSum + i;
                if(i != n/i) {
                    count++;
                    tempSum = tempSum + (n/i);
                }
                if(count > 4) {
                    return 0;
                }
            }
        }
        return count == 4 ? tempSum : 0;
    }

    public static List<List<String>> wordSquares(String[] words) {
        int n = words.length;
        List<List<String>> result = new ArrayList<List<String>>();
        for(int i = 0; i < n; i++) {
            String top = words[i];
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                String left = words[j];
                for(int k = 0; k < n; k++) {
                    if(k == i || k == j) {
                        continue;
                    }
                    String right = words[k];
                    for(int l = 0; l < n; l++) {
                        if(l == i || l == j || l  == k) {
                            continue;
                        }
                        String bottom = words[l];
                        if(top.charAt(0) == left.charAt(0) && top.charAt(3) == right.charAt(0) &&
                                bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3)) {
                            result.add(Arrays.asList(top, left, right, bottom));
                        }
                    }
                }
            }
        }
        result.sort((a,b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
        return result;
    }

    public static String largestEven(String s) {
        int temp = -1;
        for(int i =  s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '2') {
                temp = i;
                break;
            }
        }
        if(temp == -1) {
            return "";
        }
        return s.substring(0, temp+1);
    }

    public static String reversePrefix(String s, int k) {
        if(k == s.length()) {
            StringBuilder sB = new StringBuilder(s);
            sB.reverse();
            return sB.toString();
        }
        StringBuilder s1 = new StringBuilder(s.substring(0, k));
        String s2 = new String(s.substring(k, s.length()));
        s1.reverse();
        StringBuilder s3 = s1.append(s2);
        return s3.toString();
    }

    public static long maximumScore(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        int[] minSum = new int[n];
        prefixSum[0] = nums[0];
        minSum[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i = n-2; i >= 0; i--) {
            minSum[i] = Math.min(minSum[i+1], nums[i]);
        }
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++) {
            max = Math.max(max, prefixSum[i] - minSum[i+1]);
        }
        return max;
    }

    public static int maximum69Number (int num) {
        String s = Integer.toString(num);
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '6') {
                c[i] = '9';
                break;
            }
        }
        s = new String(c);
        int n = Integer.valueOf(s);
        return n;

    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static int countTriples(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <=n; j++) {
                int c = i*i + j*j;
                int d = (int) Math.sqrt(c);
                if(d <= n && d*d == c) {
                    count++;
                }
            }
        }
        return 2*count;
    }

    public static int[] sortByReflection(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int x = toReverseInt(a);
            int y = toReverseInt(b);
            if(x != y) {
                return x-y;
            }
            else {
                return a-b;
            }
        });
        for(int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static int toReverseInt(int n) {
        String binary = Integer.toBinaryString(n);
        String reverse = new StringBuilder(binary).reverse().toString();
        return Integer.parseInt(reverse, 2);
    }

    public static int largestPrime(int n) {
        int sum = 0;
        int result = 0;
        for(int i = 2; i <=n; i++) {
            if(NoIsPrime(i)) {
                sum = sum + i;
            }
            if(sum > n) {
                break;
            }
            if(NoIsPrime(sum)) {
                result = sum;
            }
        }
        return result;
    }

    public static boolean NoIsPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n == 2) {
            return true;
        }
        if(n % 2 == 0) {
            return false;
        }
        for(int i = 3; i*i <= n; i +=2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void show(int[] arr) {
        for(int a : arr) {
            System.out.print(a + " ");
        }
    }
}
