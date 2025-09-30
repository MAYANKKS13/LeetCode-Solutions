package org.example.arrayandStrings;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("0", "0"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder s1 = new StringBuilder(num1).reverse();
        StringBuilder s2 = new StringBuilder(num2).reverse();
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int length = Math.max(s1.length(), s2.length());
        for(int i = 0; i < length; i++) {
            int n1 = i < s1.length() ? s1.charAt(i) - '0' : 0;
            int n2 = i < s2.length() ? s2.charAt(i) - '0' : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }

        if(carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();


    }
}
