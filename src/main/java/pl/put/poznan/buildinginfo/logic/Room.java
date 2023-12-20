package pl.put.poznan.buildinginfo.logic;

public class Room {
    private int id;
    private String name;
    private double area;
    private double cube;

    private double lightingPower;

    private float heatingEnergyConsumption;


    public Room(int id, String name, double area, double cube, double lightingPower, float heatingEnergyConsumption) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cube = cube;
        this.lightingPower = lightingPower;
        this.heatingEnergyConsumption = heatingEnergyConsumption;
    }


//    public double calculateHeatingEnergyPerVolume() {
//        double volume = calculateVolume();
//        if (volume == 0) return 0;
//        return heatingEnergyConsumption / volume;
//    }

    // Getters
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getCube() {
        return cube;
    }


    public double getLightingPower() {
        return lightingPower;
    }

//    public double getHeatingEnergyConsumption() {
//        return heatingEnergyConsumption;
//    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCube(double cube) {
        this.cube = cube;
    }


    public void setLightingPower(double lightingPower) {
        this.lightingPower = lightingPower;
    }

//    public void setHeatingEnergyConsumption(double heatingEnergyConsumption) {
//        this.heatingEnergyConsumption = heatingEnergyConsumption;
//    }
}
