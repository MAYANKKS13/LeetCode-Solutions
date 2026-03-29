package org.example.Design;

import java.util.LinkedList;
import java.util.Queue;

public class RideSharingSystem {
    private Queue<Integer> riders;
    private Queue<Integer> drivers;

    public RideSharingSystem() {
        riders = new LinkedList<Integer>();
        drivers = new LinkedList<Integer>();
    }

    public void addRider(int riderId) {
        riders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.add(driverId);
    }

    public int[] matchDriverWithRider() {
        if(riders.isEmpty() || drivers.isEmpty()) {
            return new int[] {-1, -1};
        }
        int rider = riders.poll();
        int driver = drivers.poll();
        return new int[] {rider, driver};

    }

    public void cancelRider(int riderId) {
        riders.remove(riderId);
    }
}
