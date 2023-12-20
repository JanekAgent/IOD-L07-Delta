package pl.put.poznan.buildinginfo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents a REST controller for managing buildings.
 */
@RestController
@RequestMapping("/api/buildings")
public class RestHandlerCode {
    @Autowired
    private BuildingRepository BuildingRepository;
    
    @GetMapping
    public List<Building> getAllBuildings() {
        return BuildingRepository.findAll();
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
        // Update other floor details if needed
    }
    
    @DeleteMapping("/{buildingId}/floors/{floorId}")
    public void deleteFloor(@PathVariable(value = "buildingId") int buildingId,
                            @PathVariable(value = "floorId") int floorId) {
        Building building = BuildingRepository.findById(buildingId);
        building.deleteFloor(floorId);
    }
    
    // Add missing methods here
    
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
        // Update other room details if needed
    }
    
    @DeleteMapping("/{buildingId}/floors/{floorId}/rooms/{roomId}")
    public void deleteRoom(@PathVariable(value = "buildingId") int buildingId,
                           @PathVariable(value = "floorId") int floorId,
                           @PathVariable(value = "roomId") int roomId) {
        Building building = BuildingRepository.findById(buildingId);
        Floor floor = building.getFloorById(floorId);
        floor.deleteRoom(roomId);
    }
    
    
}