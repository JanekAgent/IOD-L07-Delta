package pl.put.poznan.buildinginfo.logic;

/**
 * The Room class represents a room in a building.
 * It contains information about the room's id, name, area, cube, lighting power, and heating energy consumption.
 */
public class Room {
    private int id;
    private String name;
    private double area;
    private double cube;
    private double lightingPower;
    private float heatingEnergyConsumption;

    /**
     * Constructs a new Room object with the specified parameters.
     *
     * @param id                        the ID of the room
     * @param name                      the name of the room
     * @param area                      the area of the room in square meters
     * @param cube                      the volume of the room in cubic meters
     * @param lightingPower             the lighting power of the room in watts
     * @param heatingEnergyConsumption  the heating energy consumption of the room in kilowatt-hours
     */
    public Room(int id, String name, double area, double cube, double lightingPower, float heatingEnergyConsumption) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cube = cube;
        this.lightingPower = lightingPower;
        this.heatingEnergyConsumption = heatingEnergyConsumption;
    }

    /**
     * Calculates the lighting power density of the room.
     *
     * @return the lighting power density in watts per square meter
     */
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


    public void setArea(double area) {
        this.area = area;
    }

    public void setCube(double cube) {
        this.cube = cube;
    }

    
    public void setLightingPower(double lightingPower) {
        this.lightingPower = lightingPower;
    }

   
    public void setHeatingEnergyConsumption(float heatingEnergyConsumption) {
        this.heatingEnergyConsumption = heatingEnergyConsumption;
    }
}


