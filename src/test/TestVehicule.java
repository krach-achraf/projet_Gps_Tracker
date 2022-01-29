package test;

import entities.Vehicule;
import service.VehiculeService;

public class TestVehicule {
    public static void main(String[] args) {
        VehiculeService vs = new VehiculeService();
        vs.create(new Vehicule("9568A88","Range Rover", "Voiture"));
        vs.create(new Vehicule("3254V25","Hyundai", "voiture"));
        vs.create(new Vehicule("3598S26","Toyota", "camion"));
    }
}
