package pl.put.poznan.buildinginfo.logic;


import java.util.List;

public class Floor implements ILocation {
    private int id;
    private String name;

    private List<Room> rooms;

    public Floor(int id, String name, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.rooms = rooms;
    }
    @Override
    public double calculateVolume() {
        double totalVolume = 0;
        for (Room room : rooms) {
            totalVolume += room.getCube();
        }
        return totalVolume;
    }
    @Override
    public double calculateArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }
    public double calculateLightingPower() {
        double totalLightingPower = 0;
        for (Room room : rooms) {
            totalLightingPower += room.getLightingPower();
        }
        return totalLightingPower;
    }

    public double calculateAverageLightingPowerDensity() {
        double levelArea = rooms.stream()
                .mapToDouble(Room::getArea  )
                .sum();
        double lightingPower = rooms.stream()
                .mapToDouble(Room::getLightingPower)
                .sum();
        if (levelArea == 0) return 0;
        return lightingPower / levelArea;
    }

    // Getters and setters
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

    // Assuming a setter for rooms
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Assuming a getter for rooms
    public List<Room> getRooms() {
        return rooms;
    }
}
