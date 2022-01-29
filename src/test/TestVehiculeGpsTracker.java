package test;

import entities.VehiculeGPSTracker;
import service.GPSTrackerService;
import service.VehiculeGPSTrackerService;
import service.VehiculeService;

import java.util.Date;

public class TestVehiculeGpsTracker {
    public static void main(String[] args) {
        VehiculeGPSTrackerService vgs = new VehiculeGPSTrackerService();
        VehiculeService vs = new VehiculeService();
        GPSTrackerService gs = new GPSTrackerService();
        vgs.create(new VehiculeGPSTracker(new Date("2020/11/07"), new Date("2021/01/01"), vs.findById(1), gs.findById(1)));
        vgs.create(new VehiculeGPSTracker( new Date("2020/01/23"), new Date("2020/06/17"), vs.findById(2), gs.findById(2)));
        vgs.create(new VehiculeGPSTracker( new Date("2021/07/01"), null, vs.findById(3), gs.findById(3)));
    }
}
