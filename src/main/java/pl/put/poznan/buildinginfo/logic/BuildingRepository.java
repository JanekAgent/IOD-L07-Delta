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
    
    
    public BuildingRepository buildingRepository() {
        
        return new BuildingRepository();
    }
    /**
     * Constructs a new instance of the BuildingRepository class.
     */
    public BuildingRepository() {
        buildings = new ArrayList<>();
    }

    /**
     * Returns a list of all buildings in the repository.
     * 
     * @return The list of all buildings.
     */
    public List<Building> getAllBuildings() {
        return buildings;
    }

    /**
     * Finds a building in the repository by its ID.
     * 
     * @param id The ID of the building to find.
     * @return The found building, or null if not found.
     */
    public Building findById(int id) {
        for (Building building : buildings) {
            if (building.getId() == id) {
                return building;
            }
        }
        return null;
    }

    /**
     * Adds a new building to the repository.
     * 
     * @param building The building to add.
     * @return The added building.
     */
    public Building addBuilding(Building building) {
        buildings.add(building);
        return building;
    }

    /**
     * Updates an existing building in the repository.
     * 
     * @param id The ID of the building to update.
     * @param updatedBuilding The updated building.
     */
    public void updateBuilding(int id, Building updatedBuilding) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                buildings.set(i, updatedBuilding);
                return ;
            }
        }
    }

    /**
     * Returns a list of all buildings in the repository.
     * 
     * @return The list of all buildings.
     */
    public List<Building> findAll() {
        return buildings;
    }

    /**
     * Deletes a building from the repository by its ID.
     * 
     * @param id The ID of the building to delete.
     */
    public void deleteBuilding(int id) {
        buildings.removeIf(building -> building.getId() == id);
    }
}
    

