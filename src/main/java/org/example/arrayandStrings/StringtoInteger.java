package org.example.arrayandStrings;

public class StringtoInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String s) {

        String s1 = s.trim();
        if(s1 == null) {
            return 0;
        }
        int i = 0;
        int sign = 1;
        if(s1.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if(s1.charAt(i) == '+') {
            i++;
        }
        int result = 0;
        while(i < s1.length() && Character.isDigit(s1.charAt(i))) {
            result = result * 10 + (s1.charAt(i) - '0');
            if(result > Integer.MAX_VALUE) {
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return sign * result;
    }


}
