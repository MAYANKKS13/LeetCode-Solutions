package org.example.arrayandStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    public static void main(String[] args) {
        int arr[] = new int[]{40,10,20,30};
        int arr1[] = new int[]{37,12,28,9,100,56,80,5,12};
        int arr2[] = new int[]{100, 100, 100};
        show(arrayRankTransform(arr));
        System.out.println();
        show(arrayRankTransform(arr1));
        System.out.println();
        show(arrayRankTransform(arr2));

    }

    public static int[] arrayRankTransform(int[] arr) {
        int result[] = new int[arr.length];
        int temp[] = arr.clone();
        Map<Integer, Integer> checkRank = new HashMap<>();
        Arrays.sort(temp);
        int rank = 1;
        for(int i = 0; i < temp.length; i++) {
            if(!checkRank.containsKey(temp[i])) {
                checkRank.put(temp[i], rank);
                rank++;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            result[i] = checkRank.get(arr[i]);
        }
        return result;
    }

    public static void show(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
