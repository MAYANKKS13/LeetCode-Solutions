package org.example.Math;

public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(4, 333));
    }

    public static float fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) {
            return (float) 0.0;
        }
        float result = (numerator / denominator);

        return result;


    }
}
