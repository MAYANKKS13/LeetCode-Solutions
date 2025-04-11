package org.example;

public class CountSymmetricIntegers {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
        System.out.println(countSymmetricIntegers(1200, 1230));

    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int n = s.length();
            if(n % 2 ==0) {
                int left = 0, right = 0;
                for(int j = 0; j < n/2; j++) {
                    left = left + s.charAt(j) - '0';
                }
                for(int j = n/2; j < n; j++) {
                    right  = right + s.charAt(j) - '0';
                }
                if(left == right) {
                    count++;
                }
            }
        }
        return count;
    }
}
