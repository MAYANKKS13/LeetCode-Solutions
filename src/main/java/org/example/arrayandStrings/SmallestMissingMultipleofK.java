package org.example.arrayandStrings;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingMultipleofK {
    public static void main (String[] args) {
        System.out.println(missingMultiple(new int[] {8,2,3,4,6}, 2));
        System.out.println(missingMultiple(new int[] {1,4,7,10,15}, 5));
    }

    public static int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(num % k == 0) {
                set.add(num);
            }
        }
        int missing = k;
        while(set.contains(missing)) {
            missing = missing + k;
        }
        return missing;





//    	for(int num : nums) {
//    		if(num % k == 0) {
//    			j++;
//    			total = total + (num/k);
//    		}
//    	}
//    	int sum = (j * (j+1))/2;
//    	if(sum - total == 0) {
//    		return k * (j+1);
//    	}
//    	sum = ((j+1) * (j+2))/2;
//    	int result = (sum - total) * k;
//    	if(result != 0) {
//    		return result;
//    	}
//    	return k;
    }

}
