package org.example.arrayandStrings;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesbyTwo {
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[] {5,3,6,1,12}, 3));
        System.out.println(findFinalValue(new int[] {2,7,9}, 4));
    }

    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(num % original == 0) {
                set.add(num);
            }
        }
        while(set.contains(original)) {
            original = 2 * original;
        }
        return original;
    }
}
