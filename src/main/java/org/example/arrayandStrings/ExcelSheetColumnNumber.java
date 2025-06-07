package org.example.arrayandStrings;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));

    }

    public static int titleToNumber(String columnTitle) {
        int number = 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            number = number * 26;
            number = number + (c - 'A' + 1);
        }
        return  number;
    }
}
