package org.example.Math;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(45));

    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
//        else {
//            return climbStairs(n - 1) + climbStairs(n - 2);
//        }

        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
