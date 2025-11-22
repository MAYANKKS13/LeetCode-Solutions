package org.example.Math;

public class CalculateMoneyinLeetcodeBank {
    public static void main (String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int total = 0;
        int j = 1;
        for(int i = 0; i < n; i++) {
            if(i % 7 == 0) {
                j = 1;
            }
            total = total + j + (i / 7);
            j++;
        }
        return total;
    }

}
