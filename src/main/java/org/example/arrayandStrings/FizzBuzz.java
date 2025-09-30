package org.example.arrayandStrings;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<String>(n);
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            }
            else if(i % 5 == 0) {
                result.add("Buzz");
            }
            else if(i % 3 == 0) {
                result.add("Fizz");
            }
            else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
