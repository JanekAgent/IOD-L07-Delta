package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Building {

    private int id;
    private String name;
    private List<Floor> floors;

    public Building(String name) {
        this.id = id;
        this.name = name;
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public double calculateTotalVolume() {
        Map<Integer, Double> volumeByLevel = new HashMap<>();

        for (Floor floor : floors) {
            volumeByLevel.merge(floor.getLevel(), floor.calculateVolume(), Double::sum);
        }

        // Sum the volumes of each level
        double totalVolume = 0;
        for (double levelVolume : volumeByLevel.values()) {
            totalVolume += levelVolume;
        }

        return totalVolume;
    }


//    public double calculateAreaByLevel(int level) {
//        double totalArea = 0;
//        for (Floor floor : floors) {
//            if (level == floor.getLevel()) {
//                totalArea += floor.calculateTotalArea();
//            }
//        }
//        return totalArea;
//    }
    public double calculateTotalArea() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateTotalArea(); // Assuming each floor has a calculateTotalArea method
        }
        return totalArea;
    }



    public double calculateAverageLightingPowerDensity() {
        double totalAverageDensity = 0;
        double totalArea = 0;
        double totalLightingPower = 0;

        for (Floor floor : floors) {
            double floorArea = floor.calculateTotalArea(); // Assuming each floor has a method to calculate its total area
            double floorLightingPower = floor.calculateTotalLightingPower(); // Assuming each floor has a method to calculate its total lighting power

            totalArea += floorArea;
            totalLightingPower += floorLightingPower;
        }

        // Calculate the average lighting power density for the entire building
        if (totalArea > 0) {
            totalAverageDensity = totalLightingPower / totalArea;
        }

        return totalAverageDensity;
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

    public int getId(){
        return id;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }


}
