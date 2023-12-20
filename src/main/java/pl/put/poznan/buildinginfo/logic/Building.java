package pl.put.poznan.buildinginfo.logic;



import java.util.List;

public class Building implements ILocation {

    private int id;
    private String name;
    private List<Floor> floors;

    public Building(String name, int id, List<Floor> floors) {
        this.id = id;
        this.name = name;
        this.floors = floors;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    @Override
    public double calculateVolume() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateVolume();
        }
        return totalArea;
    }


    @Override
    public double calculateArea() {
        double totalArea = 0;
        for (Floor floor : floors) {
            totalArea += floor.calculateArea();
        }
        return totalArea;
    }


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
