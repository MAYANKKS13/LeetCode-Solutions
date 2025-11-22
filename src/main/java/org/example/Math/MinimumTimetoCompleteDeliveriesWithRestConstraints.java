package org.example.Math;

public class MinimumTimetoCompleteDeliveriesWithRestConstraints {
    public static void main (String[] args) {
        System.out.println(minimumTime(new int[] {3,1}, new int[] {2,3}));
        System.out.println(minimumTime(new int[] {1,3}, new int[] {2,2}));
        System.out.println(minimumTime(new int[] {2,1}, new int[] {3,4}));
    }

    public static long minimumTime(int[] d, int[] r) {
        long answer = 0;
        int delivery1 = 0, delivery2 = 0;
        while(delivery1 < d[0] || delivery2 < d[1]) {
            answer++;
            boolean isDelivery1 = (delivery1 < d[0]) && (answer % r[0] != 0);
            boolean isDelivery2 = (delivery2 < d[1]) && (answer % r[1] != 0);
            if(isDelivery1 && isDelivery2) {
                if((d[0] - delivery1) >= (d[1] - delivery2)) {
                    delivery1++;
                }
                else {
                    delivery2++;
                }
            }
            else if(isDelivery1) {
                delivery1++;
            }
            else if (isDelivery2) {
                delivery2++;
            }
        }
        return answer;
    }

}
