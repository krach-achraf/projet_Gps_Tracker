package test;

import entities.Position;
import service.GPSTrackerService;
import service.PositionService;

import java.util.Date;

public class TestPosition {
    public static void main(String[] args) {
        PositionService ps = new PositionService();
        GPSTrackerService gs = new GPSTrackerService();
        ps.create(new Position(30.0550, -10.5525, new Date("2020/12/01"), gs.findById(1)));
        ps.create(new Position(32.0250, -02.0225, new Date("2021/08/19"), gs.findById(3)));
        ps.create(new Position(05.2658, -36.0355, new Date("2020/05/10"), gs.findById(2)));
    }
}
