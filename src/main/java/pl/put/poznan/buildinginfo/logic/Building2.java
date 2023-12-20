package pl.put.poznan.transformer.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Building {

    private int id;
    private String name;
    private List<Room> rooms;

    public Building(String name) {
        this.id = id;
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public double calculateTotalVolume() {

        Map<Integer, Double> volumeByLevel = new HashMap<>();
        for (Room room : rooms) {
            volumeByLevel.merge(room.getLevel(), room.getCube(), Double::sum);
        }

        double totalVolume = 0;
            for (double area : volumeByLevel.values()) {
            totalVolume += area;
        }
            return totalVolume;
    }

    // Method to calculate total volume on a given level
    public double calculateVolumeByLevel(int level) {
        double totalVolume = 0;
        for (Room room : rooms) {
            if (room.getLevel() == level) {
                totalVolume += room.getCube();
            }
        }
        return totalVolume;
    }

    public double calculateTotalArea() {
        Map<Integer, Double> areaByLevel = new HashMap<>();
        for (Room room : rooms) {
            areaByLevel.merge(room.getLevel(), room.getArea(), Double::sum);
        }

        double totalArea = 0;
        for (double area : areaByLevel.values()) {
            totalArea += area;
        }
        return totalArea;
    }

    public double calculateAreaByLevel(int level) {
        double totalArea = 0;
        for (Room room : rooms) {
            if (room.getLevel() == level) {
                totalArea += room.getArea();
            }
        }
        return totalArea;
    }

    public double calculateAverageLightingPowerDensity() {
        // Calculate the average lighting power density for each level and then average those for the entire building.
        Map<Integer, Double> lightingPowerByLevel = new HashMap<>();
        Map<Integer, Double> areaByLevel = new HashMap<>();

        // Sum lighting power and area per level
        for (Room room : rooms) {
            lightingPowerByLevel.merge(room.getLevel(), room.getLightingPower(), Double::sum);
            areaByLevel.merge(room.getLevel(), room.getArea(), Double::sum);
        }

        // Calculate average lighting power density per level
        double totalAverageDensity = 0;
        for (Integer level : lightingPowerByLevel.keySet()) {
            double levelLightingPower = lightingPowerByLevel.get(level);
            double levelArea = areaByLevel.getOrDefault(level, 0.0);
            if (levelArea > 0) {
                double levelAverageDensity = levelLightingPower / levelArea;
                totalAverageDensity += levelAverageDensity;
            }
        }

        // Get the average of averages across all levels
        int numberOfLevels = lightingPowerByLevel.size();
        if (numberOfLevels == 0) return 0;
        return totalAverageDensity / numberOfLevels;
    }


    public double calculateAverageLightingPowerDensityByLevel(int level) {
        // Calculate the average lighting power density for a specific level.
        List<Room> levelRooms = rooms.stream().filter(room -> room.getLevel() == level).collect(Collectors.toList());
        double levelArea = levelRooms.stream().mapToDouble(Room::getArea).sum();
        double levelLightingPower = levelRooms.stream().mapToDouble(Room::getLightingPower).sum();
        if (levelRooms.size() == 0) return 0;
        return levelLightingPower / levelArea;
    }

//    public double calculateTotalHeatingEnergyPerVolume() {
//        double totalVolume = calculateTotalVolume();
//        double totalHeatingEnergy = rooms.stream()
//                .mapToDouble(Room::getHeatingEnergyConsumption)
//                .sum();
//        if (totalVolume == 0) return 0;
//        return totalHeatingEnergy / totalVolume;
//    }

//    public double calculateHeatingEnergyPerVolumeByLevel(int level) {
//        double levelVolume = 0;
//        double levelHeatingEnergy = 0;
//        for (Room room : rooms) {
//            if (room.getLevel() == level) {
//                levelVolume += room.calculateVolume();
//                levelHeatingEnergy += room.getHeatingEnergyConsumption();
//            }
//        }
//        if (levelVolume == 0) return 0;
//        return levelHeatingEnergy / levelVolume;
//    }
//
//    public List<Room> findRoomsExceedingEnergyUsage(double energyUsageThreshold) {
//        return rooms.stream()
//                .filter(room -> room.calculateHeatingEnergyPerVolume() > energyUsageThreshold)
//                .collect(Collectors.toList());
//    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return new ArrayList<>(rooms); // Return a copy of the rooms list
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = new ArrayList<>(rooms); // Set a new list based on the provided list
    }
}
