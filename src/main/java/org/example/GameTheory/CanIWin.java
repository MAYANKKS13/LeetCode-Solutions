package org.example.GameTheory;

import java.util.HashSet;
import java.util.Set;

public class CanIWin {
    public static void main(String[] args) {
        System.out.println(canIWin(10, 11));
        System.out.println(canIWin(10, 0));
        System.out.println(canIWin(10, 1));
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i <= maxChoosableInteger; i++) {
            set.add(i);
        }
        if(desiredTotal == 0) {
            return true;
        }
        for(int j = 1; j < maxChoosableInteger; j++) {

        }



        return desiredTotal % (maxChoosableInteger + 1) != 0;

    }
}
