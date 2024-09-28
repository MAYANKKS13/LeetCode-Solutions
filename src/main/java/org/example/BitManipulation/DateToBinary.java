package org.example.BitManipulation;

public class DateToBinary {
    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(convertDateToBinary(date));

    }

    public static String convertDateToBinary(String date) {
        String[] numbers = date.split("-");

        int year = Integer.parseInt(numbers[0]);
        int month = Integer.parseInt(numbers[1]);
        int date1 = Integer.parseInt(numbers[2]);

        String binaryYear = Integer.toBinaryString(year);
        String binaryMonth = Integer.toBinaryString(month);
        String binaryDate = Integer.toBinaryString(date1);

        return binaryYear + "-" + binaryMonth + "-" + binaryDate;
    }
}
