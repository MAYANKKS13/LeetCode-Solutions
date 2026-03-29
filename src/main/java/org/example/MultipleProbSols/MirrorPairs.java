package org.example.MultipleProbSols;

import java.util.*;

public class MirrorPairs {
    public static void main(String[] args) {
//		System.out.println(minMirrorPairDistance(new int[] {12,21,45,33,54}));
//		System.out.println(minMirrorPairDistance(new int[] {120,21}));
//		System.out.println(minMirrorPairDistance(new int[] {21,120}));
//		System.out.println(countElements(new int[] {3,1,2}, 1));
//		System.out.println(countElements(new int[] {5,5,5}, 2));
//		System.out.println(maxDistinct("abab"));
//		System.out.println(maxDistinct("abcd"));
//		System.out.println(maxDistinct("aaaa"));
//		System.out.println(candy(new int[] {1,0,2}));
//		System.out.println(candy(new int[] {1,2,2}));
//		System.out.println(candy(new int[] {1,3,4,2}));
//		System.out.println(centeredSubarrays(new int[] {-1,1,0}));
//		System.out.println(centeredSubarrays(new int[] {2,-3}));
//		System.out.println(residuePrefixes("abc"));
//		System.out.println(residuePrefixes("bb"));
//		System.out.println(residuePrefixes("bob"));
        System.out.println(countPairs(new String[] {"fusion", "layout"}));
        System.out.println(countPairs(new String[] {"ab","aa","za","aa"}));

    }

    public static long countPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(areSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean areSimilar(String s, String t) {
        int m = s.length();
        int diff = (s.charAt(0) - t.charAt(0) + 26) % 26;
        for(int i = 0; i < m; i++) {
            int temp = (s.charAt(i) - t.charAt(i) + 26) % 26;
            if(temp != diff) {
                return false;
            }
        }
        return true;
    }

    public static int residuePrefixes(String s) {
        int n = s.length();
        int arr[] = new int[26];
        int count = 0, temp = 0;
        int length = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if(arr[index] == 0) {
                temp++;
            }
            arr[index]++;
            length += 1;
            if(temp == length%3) {
                count++;
            }
        }
        return count;
    }

    public static int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = i; j < n; j++) {
                sum = sum + nums[j];
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if(map.containsKey(sum)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int result[] = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }
        for(int i = n-2; i >=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
        }
        int total = 0;
        for(int r : result) {
            total += r;
        }
        return total;
    }

    public static int maxDistinct(String s) {
        Set<Character> set = new HashSet<Character>();
        char[] ch = s.toCharArray();
        for(char c : ch) {
            if(!set.contains(c)) {
                set.add(c);
            }
        }
        return set.size();
    }

    public static int countElements(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for(int num : nums) {
            if(n - upperBound(nums, num) >= k) {
                count++;
            }
        }
        return count;
    }

    public static int upperBound(int[] arr, int n) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + ((right - left)/2);
            if(arr[mid] <= n) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public static int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int answer = Integer.MAX_VALUE;
        boolean isPresent = false;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                answer = Math.min(answer, i - map.get(nums[i]));
                isPresent = true;
            }
            map.put(reverseNum(nums[i]), i);
        }
        return (!isPresent) ? -1 : answer;
    }

    public static int reverseNum(int num) {
        int result = 0;
        while(num > 0) {
            int temp = num % 10;
            result = (10*result) + temp;
            num = num / 10;
        }
        return result;
    }

//    public static int countElements(int[] nums, int k) {
//    	int total = 0;
//    	if(k == 0) {
//    		return nums.length;
//    	}
//    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
//    	for(int num : nums) {
//    		maxHeap.offer(num);
//    	}
//    	for(int num : nums) {
//    		List<Integer> list = new ArrayList<Integer>();
//    		int count = 0;
//    		while(!maxHeap.isEmpty() && maxHeap.peek() > num) {
//    			list.add(maxHeap.poll());
//    			count++;
//    			if(count == k) {
//    				total++;
//    				break;
//    			}
//    		}
//    		for(int num1 : list) {
//    			maxHeap.offer(num1);
//    		}
//    	}
//        return total;
//    }
}
