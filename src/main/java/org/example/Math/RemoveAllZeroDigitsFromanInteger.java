package org.example.Math;

import java.util.HashSet;
import java.util.Set;

public class RemoveAllZeroDigitsFromanInteger {
    public static void main (String[] args) {
        System.out.println(countDistinct(200));
        System.out.println(countDistinct(10));

    }

    public static long countDistinct(long n) {
        Set<Long> set = new HashSet<Long>();
        for(int i = 1; i <= n; i++) {
            set.add(remove0(i));
        }
        return set.size();
    }


    public static long remove0(int n) {
        long answer = 0;
        long tens = 1;
        while(n > 0) {
            long digit = n%10;
            if(digit != 0) {
                answer = answer + digit*tens;
                tens = 10*tens;
            }
            n = n/10;
        }
        return answer;
    }
}
