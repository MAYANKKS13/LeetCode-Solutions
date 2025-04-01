package org.example.arrayandStrings;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));

    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber = columnNumber - 1;
            s.append((char) ('A' + (columnNumber % 26)));
            columnNumber /= 26;
        }
        return s.reverse().toString();
    }

}
