package org.example.Math;

import static java.lang.Math.log;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(0));

    }

    public static boolean isPowerOfFour(int n) {

        if(n <= 0) {
            return false;
        }

        double x = log(n)/log(4);
        if(x == (int)x) {
            return true;
        }
        return false;


//        while(n > 1) {
//            if(n % 4 != 0) {
//                return false;
//            }
//            n /= 4;
//        }
//
//        return n == 1;

    }
}
