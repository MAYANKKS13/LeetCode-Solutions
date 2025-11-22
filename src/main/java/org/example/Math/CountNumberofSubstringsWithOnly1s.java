package org.example.Math;

public class CountNumberofSubstringsWithOnly1s {
    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
        System.out.println(numSub("101"));
        System.out.println(numSub("111111"));
    }

    public static int numSub(String s) {
        String[] result = s.split("0+");
        long answer = 0;
        for(String s1 : result) {
            long n = s1.length();
            answer = (answer + ((n*(n+1)/2)%1_000_000_007L)) % 1_000_000_007L;
        }
        return (int)answer;
    }

}
