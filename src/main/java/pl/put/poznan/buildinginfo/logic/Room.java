package pl.put.poznan.buildinginfo.logic;

/**
 * The Room class represents a room in a building.
 * It contains information about the room's id, name, area, cube, lighting power, and heating energy consumption.
 */
/**
 * Represents a room in a building.
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

    /**
     * Returns the ID of the room.
     *
     * @return the ID of the room
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the area of the room in square meters.
     *
     * @return the area of the room in square meters
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns the volume of the room in cubic meters.
     *
     * @return the volume of the room in cubic meters
     */
    public double getCube() {
        return cube;
    }

    /**
     * Returns the heating energy consumption of the room in kilowatt-hours.
     *
     * @return the heating energy consumption of the room in kilowatt-hours
     */
    public double getHeatingEnergyConsumption() {
        return heatingEnergyConsumption;
    }

    /**
     * Returns the lighting power of the room in watts.
     *
     * @return the lighting power of the room in watts
     */
    public double getLightingPower() {
        return lightingPower;
    }

    // Setters

    /**
     * Sets the ID of the room.
     *
     * @param id the ID of the room
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the room.
     *
     * @param name the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the area of the room in square meters.
     *
     * @param area the area of the room in square meters
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Sets the volume of the room in cubic meters.
     *
     * @param cube the volume of the room in cubic meters
     */
    public void setCube(double cube) {
        this.cube = cube;
    }

    /**
     * Sets the lighting power of the room in watts.
     *
     * @param lightingPower the lighting power of the room in watts
     */
    public void setLightingPower(double lightingPower) {
        this.lightingPower = lightingPower;
    }

    /**
     * Sets the heating energy consumption of the room in kilowatt-hours.
     *
     * @param heatingEnergyConsumption the heating energy consumption of the room in kilowatt-hours
     */
    public void setHeatingEnergyConsumption(float heatingEnergyConsumption) {
        this.heatingEnergyConsumption = heatingEnergyConsumption;
    }
}


