package org.example.Math;

public class MaxBottlesDrunk {
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(13, 6));
        System.out.println(maxBottlesDrunk(10, 3));
        System.out.println(maxBottlesDrunk(10, 4));

    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxBottle = numBottles;
        int emptyBottle = numBottles;
        while( emptyBottle >= numExchange) {
            emptyBottle = emptyBottle - numExchange + 1;
            maxBottle++;
            numExchange++;
        }
        return maxBottle;

    }
}
