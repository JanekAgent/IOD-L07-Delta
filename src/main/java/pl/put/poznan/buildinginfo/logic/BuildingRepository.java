package pl.put.poznan.buildinginfo.logic;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


/**
 * The BuildingRepository class represents a repository for managing buildings.
 * It provides methods for adding, updating, deleting, and retrieving buildings.
 */
@Repository
public class BuildingRepository {
    private List<Building> buildings;

    public BuildingRepository() {
        buildings = new ArrayList<>();
    }

    public List<Building> getAllBuildings() {
        return buildings;
    }

    public Building findById(int id) {
        for (Building building : buildings) {
            if (building.getId() == id) {
                return building;
            }
        }
        return null;
    }

    public Building addBuilding(Building building) {
        buildings.add(building);
        return building;
    }

    public void updateBuilding(int id, Building updatedBuilding) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                buildings.set(i, updatedBuilding);
                return ;
            }
        }
    }
    public List<Building> findAll() {
        return buildings;
    }

    public void deleteBuilding(int id) {
        buildings.removeIf(building -> building.getId() == id);
    }
    
        
}
    

