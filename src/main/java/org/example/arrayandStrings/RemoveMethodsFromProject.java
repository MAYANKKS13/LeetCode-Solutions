package org.example.arrayandStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveMethodsFromProject {
    public static void main(String[] args) {
        int nums[][] = new int[][]{{1,2},{0,1},{3,2}};
        int nums1[][] = new int[][]{{1,2},{0,2},{0,1},{3,4}};
        int nums2[][] = new int[][]{{1,2},{0,1},{2,0}};

        System.out.println(remainingMethods(4, 1, nums));
        System.out.println(remainingMethods(5, 0, nums1));
        System.out.println(remainingMethods(3, 2, nums2));

    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> set = new HashSet<>();
        set.add(k);

        boolean remove = true;
        for(int[] invocation : invocations) {
            int a = invocation[0];
            int b = invocation[1];
            if(set.contains(a)) {
                set.add(b);
            }

            if(!set.contains(a) && set.contains(b)) {
                remove = false;
                break;
            }
        }

        if(!remove) {
            return printAll(n);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }


    public static List<Integer> printAll(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }
}
