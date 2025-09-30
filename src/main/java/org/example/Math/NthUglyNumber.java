package org.example.Math;

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber(200));
    }

    public static int nthUglyNumber(int n) {
        int num = 1;
        int count = 0;
        while(true) {
            if(hasPrimeFactors(num)) {
                count++;
                if(count == n) {
                    return num;
                }
            }
            num++;
        }
    }

    public static boolean hasPrimeFactors(int n) {
        if(n <= 0) {
            return false;
        }

        while(n % 2 == 0) {
            n = n / 2;
        }
        while(n % 3 == 0) {
            n = n / 3;
        }
        while(n % 5 == 0) {
            n = n / 5;
        }
        if(n == 1) {
            return true;
        }
        return false;

    }
}
