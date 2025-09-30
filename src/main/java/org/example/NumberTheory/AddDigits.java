package org.example.NumberTheory;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(0));
        System.out.println(addDigits(137));


    }

    public static int addDigits(int num) {
//    	if(num == 0) {
//    		return 0;
//    	}
//    	else if(num % 9 == 0) {
//    		return 9;
//    	}
//        return (num % 9);

        return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
}
