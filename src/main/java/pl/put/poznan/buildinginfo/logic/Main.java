package pl.put.poznan.transformer.app;

public class Main {
    public static void main(String[] args) {
        // Create a new building instance
        Building building = new Building("Example Building");

        // Create rooms and add them to the building
        Room room1 = new Room("Room 101", 5.0, 4.0, 3.0, 1, 120.0);
//        room1.setHeatingEnergyConsumption(500); // in kWh
        building.addRoom(room1);

        Room room2 = new Room("Room 102", 6.0, 4.0, 3.0, 1, 150.0);
//        room2.setHeatingEnergyConsumption(600); // in kWh
        building.addRoom(room2);

        Room room3 = new Room("Room 201", 5.0, 4.0, 3.0, 2, 100.0);
//        room3.setHeatingEnergyConsumption(550); // in kWh
        building.addRoom(room3);

        Room room4 = new Room("Room 202", 7.0, 4.0, 3.0, 2, 200.0);
//        room4.setHeatingEnergyConsumption(650); // in kWh
        building.addRoom(room4);

        // Calculate and print total building area and volume
        System.out.println("Total building area: " + building.calculateTotalArea() + " m^2");
        System.out.println("Total building volume: " + building.calculateTotalVolume() + " m^3");

        // Calculate and print area and volume for level 1
        System.out.println("Total area of level 1: " + building.calculateAreaByLevel(1) + " m^2");
        System.out.println("Total volume of level 1: " + building.calculateVolumeByLevel(1) + " m^3");

        // Calculate and print average lighting power density for the building and level 1
        System.out.println("Average lighting power density for the building: " + building.calculateAverageLightingPowerDensity() + " W/m^2");
        System.out.println("Average lighting power density for level 1: " + building.calculateAverageLightingPowerDensityByLevel(1) + " W/m^2");

        // Calculate and print heating energy per volume for the building and level 1
        System.out.println("Total heating energy per volume for the building: " + building.calculateTotalHeatingEnergyPerVolume() + " kWh/m^3");
        System.out.println("Heating energy per volume for level 2: " + building.calculateHeatingEnergyPerVolumeByLevel(2) + " kWh/m^3");

        // Find and print rooms exceeding a certain threshold of heating energy per volume
        double threshold = 0.15; // kWh/m^3
        System.out.println("Rooms exceeding heating energy threshold of " + threshold + " kWh/m^3:");
//        for (Room room : building.findRoomsExceedingEnergyUsage(threshold)) {
//            System.out.println(room.getName() + " with " + room.calculateHeatingEnergyPerVolume() + " kWh/m^3");
//        }
    }
}
