package org.example.NumberTheory;

public class MirrorReflection {
    public static void main(String[] args) {
        System.out.println(mirrorReflection(2, 1));
        System.out.println(mirrorReflection(3, 1));

    }

    public static int mirrorReflection(int p, int q) {
        while(p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if(p % 2 == 0) {
            return 2;
        }
        else if(q % 2 == 0) {
            return 0;
        }
        return 1;
    }
}
