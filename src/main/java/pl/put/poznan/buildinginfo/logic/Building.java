package pl.put.poznan.buildinginfo.logic;



import java.util.List;

/**
 * The Building class represents a building.
 * It contains information about the building's id, name, and floors.
 */
public class Building implements ILocation {

    private int id;
    private String name;
    private List<Floor> floors;

    /**
     * Constructs a Building object with the specified name, id, and floors.
     *
     * @param name   the name of the building
     * @param id     the id of the building
     * @param floors the list of floors in the building
     */
    public Building(String name, int id, List<Floor> floors) {
        this.id = id;
        this.name = name;
        this.floors = floors;
    }

    /**
     * Adds a floor to the building.
     *
     * @param floor the floor to be added
     * @return the added floor
     */
    public Floor addFloor(Floor floor) {
        floors.add(floor);
        return floor;
    }

    /**
     * Calculates the volume of the building.
     *
     * @return the volume of the building
     */
    @Override
    public double calculateVolume() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateVolume();
        }
        return totalArea;
    }

    /**
     * Calculates the area of the building.
     *
     * @return the area of the building
     */
    @Override
    public double calculateArea() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateArea();
        }
        return totalArea;
    }

    /**
     * Calculates the average lighting power density of the building.
     *
     * @return the average lighting power density of the building
     */
    public double calculateAverageLightingPowerDensity() {
        double totalAverageDensity = 0;
        double totalArea = 0;
        double totalLightingPower = 0;

        for (Floor floor : floors) {
            double floorArea = floor.calculateArea();
            double floorLightingPower = floor.calculateLightingPower();
            totalArea += floorArea;
            totalLightingPower += floorLightingPower;
        }

        if (totalArea > 0) {
            totalAverageDensity = totalLightingPower / totalArea;
        }

        return totalAverageDensity;
    }

    /**
     * Deletes a floor from the building based on the floor id.
     *
     * @param floorId the id of the floor to be deleted
     */
    public void deleteFloor(int floorId) {
        floors.removeIf(floor -> floor.getId() == floorId);
    }

    /**
     * Retrieves a floor from the building based on the floor id.
     *
     * @param floorId the id of the floor to be retrieved
     * @return the floor with the specified id, or null if not found
     */
    public Floor getFloorById(int floorId) {
        for (Floor floor : floors) {
            if (floor.getId() == floorId) {
                return floor;
            }
        }
        return null;
    }

    /**
     * Sets the list of floors in the building.
     *
     * @param floors the list of floors to be set
     */
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    // Getters

    /**
     * Retrieves the name of the building.
     *
     * @return the name of the building
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the id of the building.
     *
     * @return the id of the building
     */
    public int getId() {
        return id;
    }

    // Setters

    /**
     * Sets the name of the building.
     *
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the id of the building.
     *
     * @param id the id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the list of floors in the building.
     *
     * @return the list of floors in the building
     */
    public List<Floor> getFloors() {
        return floors;
    }

}
