package org.example;

public class Main {
    public static void main(String[] args) {

        int[] nums = {3, 4, 5};
        System.out.println(triangleType(nums));
    }

    public static String triangleType(int[] nums) {
        if(nums[0] + nums[1] >= nums[2] && nums[1] + nums[2] >= nums[0] && nums[2] + nums[0] >= nums[1]) {
            if(nums[0] == nums[1] && nums[2] == nums[1] && nums[2] == nums[0]) {
                return "equilateral";
            }
            else if(nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]) {
                return "isosceles";
            }
            else {
                return "scalene";
            }
        }
        return "none";

    }
}