package pl.put.poznan.buildinginfo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildinginfo.logic.BuildingRepository;
// o Wejście w formacie JSON odpowiadające strukturze budynku (listy, słowniki)
// o Wejście transformowane do postaci modelu obiektowego 
// o Wyjście w formacie JSON
// o REST API umożliwia uruchomienie dowolnej aktualnie zaimplementowanej funkcji.
// • Lokacja to budynek, poziom, lub pomieszczenie
// • Budynek może składać się z poziomów a te z pomieszczeń
// • Każda lokalizacja jest charakteryzowana przez:
//     o id – unikalny identyfikator
//    o name – opcjonalna nazwa lokalizacji
// • Pomieszczenie dodatkowo jest charakteryzowane przez:
//    o area = powierzchnia w m^2
//    o cube = kubatura pomieszczenia w m^3
//    o heating = poziom zużycia energii ogrzewania (float)
//    o light – łączna moc oświetlenia
// @RestController
@RequestMapping("/api/buildings")
public class RestController {
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
        building.setAddress(buildingDetails.getAddress());
        // building.setFloors(buildingDetails.getFloors());
        
        BuildingRepository.updateBuilding(1, building);
        return ;
    }
    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable(value = "id") int buildingId) {
        BuildingRepository.deleteBuilding(buildingId);
        return ;
    }
    
    
}
