package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class BuildingTest{
    private Building building;
    private List<Floor> floors;
    @BeforeEach
    void setUp(){
        floors= new ArrayList<>();
        Floor floor = new Floor(1, "test1");
        Floor floor2 = new Floor(2,"test2");
        Floor floor3 = new Floor(3,"test3");
        floor.addRoom(new Room(0, "test1", 10, 20, 30, 40));
        floor.addRoom(new Room(1, "test2", 11, 21, 31, 41));
        floor2.addRoom(new Room(0, "roomtest1", 100, 200, 300, 400));
        floors.add(floor);
        floors.add(floor2);
        floors.add(floor3);

        building = new Building("test", 1, floors);
    }
    @Test
    void addFloorTest(){
        Floor floor= new Floor(1, null);
        assertEquals(floor, building.addFloor(floor));
    }
    @Test
    void calculateVolumeTest(){
        assertEquals(241, building.calculateVolume());
    }
    @Test
    void calculateAreaTest(){
        assertEquals(121, building.calculateArea());
    }
    @Test
    void calcluateLightPowerDensityTest(){
        assertEquals(2.9834710743801653, building.calculateAverageLightingPowerDensity());
    }
    @Test
    void getFloorByIdTest(){
        Floor floor = new Floor(123, null);
        building.addFloor(floor);
        assertEquals(floor, building.getFloorById(123));
    }
    @Test 
    void deleteFloor(){
        Floor floor = new Floor(123, null);
        building.addFloor(floor);
        assertEquals(floor, building.getFloorById(123));
        building.deleteFloor(123);
        assertEquals(null, building.getFloorById(123));
    }
    
} 