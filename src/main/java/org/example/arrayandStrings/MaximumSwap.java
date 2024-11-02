package org.example.arrayandStrings;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));

    }

    public static int maximumSwap(int num) {
        char number[] = Integer.toString(num).toCharArray();
        for(int i = 0; i < number.length; i++) {
            int max = i;
            for(int j = i + 1; j < number.length; j++) {
                if(number[j] >= number[max]) {
                    max = j;
                }
            }
            if(max != i && number[max] != number[i]) {
                char temp = number[max];
                number[max] = number[i];
                number[i] = temp;
                break;
            }
        }
        String result = new String(number);
        return Integer.parseInt(result);
    }
}
