package pl.put.poznan.buildinginfo.logic;


import java.util.List;

/**
 * The Floor class represents a floor in a building.
 * It contains information about the floor's ID, name, level, and a list of rooms.
 * The class provides methods to calculate the volume, total area, total lighting power,
 * and average lighting power density of the rooms on the floor.
 */
public class Floor implements ILocation {
    private int id;
    private String name;
    private List<Room> rooms;

    /**
     * Constructs a new Floor object with the specified ID and name.
     *
     * @param id   the ID of the floor
     * @param name the name of the floor
     */
    public Floor(int id, String name) {
        this.id = id;
        this.name = name;
        
    }
    
    /**
     * Calculates the total volume of all rooms on the floor.
     *
     * @return the total volume of all rooms on the floor
     */
    @Override
    public double calculateVolume() {
        double totalVolume = 0;
        for (Room room : rooms) {
            totalVolume += room.getCube();
        }
        return totalVolume;
    }
    
    /**
     * Calculates the total area of all rooms on the floor.
     *
     * @return the total area of all rooms on the floor
     */
    @Override
    public double calculateArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }
    /**
     * Calculates the total lighting power of all rooms on the floor.
     *
     * @return the total lighting power of all rooms on the floor
     */
    public double calculateLightingPower() {
        double totalLightingPower = 0;
        for (Room room : rooms) {
            totalLightingPower += room.getLightingPower();
        }
        return totalLightingPower;
    }

    /**
     * Calculates the average lighting power density of all rooms on the floor.
     *
     * @return the average lighting power density of all rooms on the floor
     */
    public double calculateAverageLightingPowerDensity() {
        double levelArea = rooms.stream()
                .mapToDouble(Room::getArea)
                .sum();
        double lightingPower = rooms.stream()
                .mapToDouble(Room::getLightingPower)
                .sum();
        if (levelArea == 0) return 0;
        return lightingPower / levelArea;
    }

    // Getters and setters are not documented

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    // Assuming a getter for rooms
    public List<Room> getRooms() {
        return rooms;
    }
}
