package org.example.Math;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));

    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        return ((ax2 - ax1) * (ay2 - ay1)) + ((bx2 - bx1) * (by2 - by1)) - ((Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1))) * (Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1))));

        /*
        int area = 0;
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int width = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int height = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int tempArea = width * height;
        area = area1 + area2 - tempArea;

        return area;
         */

    }
}
