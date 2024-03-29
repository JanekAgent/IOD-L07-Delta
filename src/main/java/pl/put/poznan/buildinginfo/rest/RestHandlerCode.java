package pl.put.poznan.buildinginfo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.buildinginfo.logic.BuildingRepository;
import pl.put.poznan.buildinginfo.logic.Building;
import pl.put.poznan.buildinginfo.logic.Floor;
import pl.put.poznan.buildinginfo.logic.Room;

import java.util.List;
// import org.springframework.web.bind.annotation.RestController;


/**
 * This class represents the REST API handler for managing buildings, floors, and rooms.
 * It provides endpoints for retrieving, creating, updating, and deleting building, floor, and room data.
 */
@RestController
@RequestMapping("/api")
public class RestHandlerCode {
    @Autowired
    private BuildingRepository BuildingRepository;
    
    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        System.out.println("getAllBuildings");
        return BuildingRepository.findAll();
    }
    @GetMapping("/test")   
    public String test() {
        System.out.println("test");
        return "test";
    }
    
    @GetMapping("/{id}")
    public Building getBuildingById(@PathVariable(value = "id") int buildingId) {
        return BuildingRepository.findById(buildingId);
    }
    
    @PostMapping
    public Building createBuilding(@RequestBody Building building) {
        return BuildingRepository.addBuilding(building);
    }
    
    @PutMapping("/{id}")
    public void updateBuilding(@PathVariable(value = "id") int buildingId,
                                            @RequestBody Building buildingDetails) {
        Building building = BuildingRepository.findById(buildingId);
        building.setName(buildingDetails.getName());
        
        // building.setFloors(buildingDetails.getFloors());
        
        BuildingRepository.updateBuilding(1, building);
        return ;
    }
    
    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable(value = "id") int buildingId) {
        BuildingRepository.deleteBuilding(buildingId);
        return ;
    }
    
    
    @GetMapping("/{buildingId}/floors")
    public List<Floor> getAllFloors(@PathVariable(value = "buildingId") int buildingId) {
        Building building = BuildingRepository.findById(buildingId);
        return building.getFloors();
    }
    
    @GetMapping("/{buildingId}/floors/{floorId}")
    public Floor getFloorById(@PathVariable(value = "buildingId") int buildingId,
                              @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        return building.getFloorById(floorId);
    }
    
    @PostMapping("/{buildingId}/floors")
    public Floor createFloor(@PathVariable(value = "buildingId") int buildingId,
                             @RequestBody Floor floor) {
        Building building = BuildingRepository.findById(buildingId);
        return building.addFloor(floor);
    }
    
    @PutMapping("/{buildingId}/floors/{floorId}")
    public void updateFloor(@PathVariable(value = "buildingId") int buildingId,
                            @PathVariable(value = "floorId") int floorId,
                            @RequestBody Floor floorDetails) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        floor.setName(floorDetails.getName());
        
    }
    
    @DeleteMapping("/{buildingId}/floors/{floorId}")
    public void deleteFloor(@PathVariable(value = "buildingId") int buildingId,
                            @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        building.deleteFloor(floorId);
    }
    
    
    
    @GetMapping("/{buildingId}/floors/{floorId}/rooms")
    public List<Room> getAllRooms(@PathVariable(value = "buildingId") int buildingId,
                                  @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        return floor.getRooms();
    }
    
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}")
    public Room getRoomById(@PathVariable(value = "buildingId") int buildingId,
                            @PathVariable(value = "floorId") int floorId,
                            @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        return floor.getRoomById(roomId);
    }
    
    @PostMapping("/{buildingId}/floors/{floorId}/rooms")
    public Room createRoom(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @RequestBody Room room) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        return floor.addRoom(room);
    }
    
    @PutMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}")
    public void updateRoom(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId,
                           @RequestBody Room roomDetails) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        room.setName(roomDetails.getName());
        
    }
    
    @DeleteMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}")
    public void deleteRoom(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        floor.deleteRoom(roomId);
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/powerDensity")
    public double getRoomPowerDensity(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.calculateLightingPowerDensity();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/heatingEnergyConsumption")
    public double getRoomHeatingEnergyConsumption(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.getHeatingEnergyConsumption();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/cube")
    public double getRoomCube(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.getCube();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/area")
    public double getRoomArea(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.getArea();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/lightingPower")
    public double getRoomLightingPower(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.getLightingPower();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/name")
    public String getRoomName(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.getName();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/id")
    public int getRoomId(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        return room.getId();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}/LightingPowerDensity")
    public double getRoomLightingPowerDensity(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        Room room = floor.getRoomById(roomId);
        
        return room.calculateLightingPowerDensity();
    }
    @GetMapping("/{buildingId}/Volume")
    public double getBuildingVolume(@PathVariable(value = "buildingId") int buildingId) {
        Building building = BuildingRepository.findById(buildingId);
        return building.calculateVolume();
    }
    @GetMapping("/{buildingId}/Area")
    public double getBuildingArea(@PathVariable(value = "buildingId") int buildingId) {
        Building building = BuildingRepository.findById(buildingId);
        return building.calculateArea();
    }
    @GetMapping("/{buildingId}/LightingPowerDensity")
    public double getBuildingLightingPowerDensity(@PathVariable(value = "buildingId") int buildingId) {
        Building building = BuildingRepository.findById(buildingId);
        return building.calculateAverageLightingPowerDensity();
    }
    
    @GetMapping("/{buildingId}/floors/{floorId}/Volume")
    public double getFloorVolume(@PathVariable(value = "buildingId") int buildingId,
                                @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        return floor.calculateVolume();
    }
    
    
    @GetMapping("/{buildingId}/floors/{floorId}/Area")
    public double getFloorArea(@PathVariable(value = "buildingId") int buildingId,
                            @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        return floor.calculateArea();
    }
    @GetMapping("/{buildingId}/floors/{floorId}/LightingPowerDensity")
    public double getFloorLightingPowerDensity(@PathVariable(value = "buildingId") int buildingId,
                            @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        return floor.calculateAverageLightingPowerDensity();
    }

    
}