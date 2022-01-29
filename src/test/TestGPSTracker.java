package test;

import entities.GPSTracker;
import service.GPSTrackerService;


public class TestGPSTracker {
    public static void main(String[] args) {
        GPSTrackerService gs = new GPSTrackerService();
        gs.create(new GPSTracker("01259"));
        gs.create(new GPSTracker("15986"));
        gs.create(new GPSTracker("95682"));
    }
}
