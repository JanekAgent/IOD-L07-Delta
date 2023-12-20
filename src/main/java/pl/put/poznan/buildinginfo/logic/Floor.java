package pl.put.poznan.buildinginfo.logic;


import java.util.List;

public class Floor {
    private int id;
    private String name;

    private int level;
    private List<Room> rooms;

    public Floor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public double calculateVolume() {
        double totalVolume = 0;
        for (Room room : rooms) {
            totalVolume += room.getCube();
        }
        return totalVolume;
    }

    public double calculateTotalArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }

    public double calculateTotalLightingPower() {
        double lightingPower = rooms.stream()
                .mapToDouble(Room::getLightingPower)
                .sum();
        return lightingPower;
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

    public int getLevel(){
        return level;
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
