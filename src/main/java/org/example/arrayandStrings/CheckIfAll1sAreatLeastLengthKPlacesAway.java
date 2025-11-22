package org.example.arrayandStrings;

public class CheckIfAll1sAreatLeastLengthKPlacesAway {
    public static void main (String[] args) {
        System.out.println(kLengthApart(new int[] {1,0,0,0,1,0,0,1}, 2));
        System.out.println(kLengthApart(new int[] {1,0,0,1,0,1}, 2));

    }

    public static boolean kLengthApart(int[] nums, int k) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(j != 0 && (i - j - 1) < k) {
                    return false;
                }
                j = i;
            }
        }
        return true;
    }
}
