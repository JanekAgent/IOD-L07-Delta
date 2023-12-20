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

    public double calculateLightingPowerDensity() {
        if (area == 0) return 0;
        return lightingPower / area;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getCube() {
        return cube;
    }
    public double getHeatingEnergyConsumption() {
        return heatingEnergyConsumption;
    }


    

    public double getLightingPower() {
        return lightingPower;
    }



    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setCube(float cube) {
        this.cube = cube;
    }

   

    public void setLightingPower(float lightingPower) {
        this.lightingPower = lightingPower;
    }

    public void setHeatingEnergyConsumption(float heatingEnergyConsumption) {
        this.heatingEnergyConsumption = heatingEnergyConsumption;
    }
}


