package pl.put.poznan.buildinginfo.logic;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Building {

    private int id;
    private String name;
    private List<Floor> floors;

    public Building(String name,int id) {
        this.id = id;
        this.name = name;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public double calculateTotalVolume() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateVolume();
        }
        return totalArea;
    }



    public double calculateTotalArea() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateTotalArea();
        }
        return totalArea;
    }



    public double calculateAverageLightingPowerDensity() {
        double totalAverageDensity = 0;
        double totalArea = 0;
        double totalLightingPower = 0;

        for (Floor floor : floors) {
            double floorArea = floor.calculateTotalArea();
            double floorLightingPower = floor.calculateTotalLightingPower();
            totalArea += floorArea;
            totalLightingPower += floorLightingPower;
        }

        if (totalArea > 0) {
            totalAverageDensity = totalLightingPower / totalArea;
        }

        return totalAverageDensity;
    }





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

    public void setId(int id){
        this.id = id;
    }


}
