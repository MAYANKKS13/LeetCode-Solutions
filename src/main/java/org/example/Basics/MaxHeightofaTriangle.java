package org.example.Basics;

public class MaxHeightofaTriangle {
    public static void main(String[] args) {
        int red = 2, blue = 4;
        int red1 = 2, blue1 = 1;
        int red2 = 1, blue2 = 1;
        int red3 = 10, blue3 = 1;
        System.out.println(maxHeightofaTriangle(red, blue));
        System.out.println(maxHeightofaTriangle(red1, blue1));
        System.out.println(maxHeightofaTriangle(red2, blue2));
        System.out.println(maxHeightofaTriangle(red3, blue3));

    }

    public static int maxHeightofaTriangle(int red, int blue) {
        return Math.max(heightWithBlue(red, blue), heightWithRed(red, blue));
    }

    public static int heightWithRed(int red, int blue) {
        boolean isRed = true;
        int height = 0;
        while (red >= 0 && blue >= 0) {
            height = height + 1;
            if(isRed) {
                red = red - height;
            }
            if(!isRed) {
                blue = blue - height;
            }
            isRed = !isRed;
        }
        return height - 1;
    }

    public static int heightWithBlue(int red, int blue) {
        boolean isBlue = true;
        int height = 0;
        while (blue >= 0 && red >= 0) {
            height = height + 1;
            if(isBlue) {
                blue = blue - height;
            }
            if(!isBlue) {
                red = red - height;
            }
            isBlue = !isBlue;
        }
        return height - 1;
    }
}
