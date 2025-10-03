package org.example.Math;

public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(10, 4));

    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int maxBottle = numBottles;
        int emptyBottle = numBottles;
        while( emptyBottle >= numExchange) {
            int temp = emptyBottle/numExchange;
            maxBottle = maxBottle + temp;
            emptyBottle = (emptyBottle%numExchange) + temp;

        }
        return maxBottle;
    }
}
