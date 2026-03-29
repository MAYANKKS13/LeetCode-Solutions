package org.example.MultipleProbSols;

import java.util.*;

public class MinOperations {
    public static void main(String[] args) {
//		show(minOperations(new int[] {1,2,4}));
//		System.out.println();
//		show(minOperations(new int[] {6,7,12}));
//		System.out.println(maxPoints(new int[] {5,2,10}, new int[] {10,3,8}, 2));
//		System.out.println(maxPoints(new int[] {10,20,30}, new int[] {5,15,25}, 2));
//		System.out.println(maxPoints(new int[] {1,2,3}, new int[] {4,5,6}, 0));
//		System.out.println(completePrime(23));
//		System.out.println(completePrime(39));
//		System.out.println(completePrime(7));
//		System.out.println(countMonobit(1));
//		System.out.println(countMonobit(4));
//		System.out.println(minimumCost(new int[] {1,2,3,12}));
//		System.out.println(minimumCost(new int[] {5,4,3}));
//		System.out.println(minimumCost(new int[] {10,3,1,1}));
//		show(constructTransformedArray(new int[] {3,-2,1,1}));
//		show(constructTransformedArray(new int[] {-1,4,-1}));
//		System.out.println(dominantIndices(new int[] {5,4,3}));
//		System.out.println(dominantIndices(new int[] {4,1,2}));
//		System.out.println(mergeAdjacent(new int[] {3,1,1,2}));
//		System.out.println(mergeAdjacent(new int[] {2,2,4}));
//		System.out.println(mergeAdjacent(new int[] {3,7,5}));
//		System.out.println(mapWordWeights(new String[] {"abcd","def","xyz"},
//				new int[] {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2}));
//		System.out.println(mapWordWeights(new String[] {"a","b","c"},
//				new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
//		System.out.println(mapWordWeights(new String[] {"abcd"},
//				new int[] {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5}));
//		System.out.println(prefixConnected(new String[] {"apple","apply","banana","bandit"}, 2));
//		System.out.println(prefixConnected(new String[] {"car","cat","cartoon"}, 3));
//		System.out.println(prefixConnected(new String[] {"bat","dog","dog","doggy","bat"}, 2));
        System.out.println(rob(new int[] {1,4,3,5}, new int[] {1,1,2,2}));
        System.out.println(rob(new int[] {3,1,2,4}, new int[] {2,3,2,2}));
        System.out.println(rob(new int[] {10,1,3,9}, new int[] {1,1,1,2}));
    }

    public static long rob(int[] nums, int[] colors) {
        Map<Integer, Integer> money = new HashMap<Integer, Integer>();
        Map<Integer, Integer> colour = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            money.put(i, nums[i]);
            colour.put(i, colors[i]);
        }
        int robbedHouse = money.get(0);
        int skippedHouse = 0;
        for(int i = 1; i < nums.length; i++) {
            int currMoney = money.get(i);
            int currColour = colour.get(i);
            int robbedMoney;
            if(currColour != colour.get(i-1)) {
                robbedMoney = robbedHouse + currMoney;
            }
            else {
                robbedMoney = skippedHouse + currMoney;
            }
            int skip = Math.max(robbedHouse, skippedHouse);
            robbedHouse = robbedMoney;
            skippedHouse = skip;
        }
        return Math.max(robbedHouse, skippedHouse);
    }

    public static int prefixConnected(String[] words, int k) {
        int count = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s : words) {
            if(s.length() >= k) {
                String temp = s.substring(0, k);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for(int i : map.values()) {
            if(i >= 2) {
                count++;
            }
        }
        return count;
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        String result = "";
        for(String s: words) {
            int sum = 0;
            for(int i = 0; i < s.length(); i++) {
                sum = sum + weights[s.charAt(i) - 'a'];
            }
            result = result + (char)('a' + (25 - (sum%26)));
        }
        return result;
    }

    public static List<Long> mergeAdjacent(int[] nums) {
        List<Long> list = new ArrayList<Long>();
        for(long i : nums) {
            while(!list.isEmpty() && list.get(list.size() - 1) == i) {
                i = i + list.remove(list.size() - 1);
            }
            list.add(i);
        }
        return list;

//    	for(int i : nums) {
//    		list.add((long)i);
//    	}
//    	boolean start = true;
//    	while(start) {
//    		start = false;
//    		for(int i = 0; i < list.size()-1; i++) {
//    			if(list.get(i).equals(list.get(i+1))) {
//    				long sum = list.get(i) + list.get(i+1);
//    				list.set(i, sum);
//    				list.remove(i+1);
//    				start = true;
//    				break;
//    			}
//    		}
//    	}
    }

    public static int dominantIndices(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return 0;
        }
        int sum = 0;
        for(int i : nums) {
            sum = sum + i;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            sum = sum - nums[i];
            int right = n - 1 - i;
            if((long)nums[i]*right > sum) {
                count++;
            }
        }
        return count;
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                int j = (i + nums[i]) % n;
                ans[i] = nums[j];
            }
            else if(nums[i] < 0) {
                int pos = Math.abs(nums[i]) % n;
                int j = (i - pos + n) % n;
                ans[i] = nums[j];
            }
            else if(nums[i] == 0) {
                ans[i] = nums[i];
            }
        }
        return ans;
    }

    public static int minimumCost(int[] nums) {
        int n = nums.length;
        int num = nums[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int index1 = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] < min1) {
                min1 = nums[i];
                index1 = i;
            }
        }
        for(int i = 1; i < n; i++) {
            if(i == index1) {
                continue;
            }
            if(nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return (num + min1 + min2);

    }

    public static int countMonobit(int n) {
        if(n == 0) {
            return 1;
        }
        int count = 2;
        int num = 3;
        while(num <= n) {
            count++;
            num = (num << 1) | 1;
        }
        return count;
    }

    public static boolean completePrime(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        for(int i = 1; i <= n; i++) {
            int prefx = Integer.parseInt(s.substring(0, i));
            if(!isPrime(prefx)) {
                return false;
            }
        }
        for(int i = 0; i < n; i++) {
            int suffix = Integer.parseInt(s.substring(i, n));
            if(!isPrime(suffix)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int n) {
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

    public static long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            if(pq.size() < k) {
                pq.offer(i);
            }
            else if(!pq.isEmpty() && (technique1[i] > technique1[pq.peek()])) {
                pq.poll();
                pq.offer(i);
            }
        }
        long total = 0;
        boolean[] isAdded = new boolean[n];
        for(int index : pq) {
            isAdded[index] = true;
            total = total + technique1[index];
        }
        for(int i = 0; i < n; i++) {
            if(!isAdded[i]) {
                total = total + Math.max(technique1[i], technique2[i]);
            }
        }
        return total;
    }

    public static int[] minOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int temp = 0, temp1 = 0;
            int a = 0, b = 0;
            while(true) {
                if(isPalindrom(num - temp)) {
                    a = temp;
                    break;
                }
                temp++;
            }
            while(true) {
                if(isPalindrom(num + temp1)) {
                    b = temp1;
                    break;
                }
                temp1++;
            }
            result[i] = Math.min(a, b);
        }
        return result;
    }

    public static boolean isPalindrom(int n) {
        String binary = Integer.toBinaryString(n);
        int left = 0, right = binary.length() - 1;
        while(left < right) {
            if(binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void show(int[] arr) {
        for(int a : arr) {
            System.out.print(a + ", ");
        }
    }
}
