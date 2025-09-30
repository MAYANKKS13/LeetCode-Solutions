package org.example.arrayandStrings;

public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.2", "1.10"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.1", "1.0.0.0"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int max = Math.max(arr1.length, arr2.length);
        for(int i = 0; i < max; i++) {
            int num1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            int num2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;
            if(num1 > num2) return 1;
            if(num1 < num2) return -1;
        }
        return 0;

    }
}
