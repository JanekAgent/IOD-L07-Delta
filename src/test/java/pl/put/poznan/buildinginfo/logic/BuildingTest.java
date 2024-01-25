package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


class BuildingTest{
    private Building building;
    private List<Floor> floors;
    @BeforeEach
    void setUp(){
        
        building = new Building("test", 1, floors);
    }

    
    @Test
    void addFloorTest(){
        Floor ek = new Floor(0, "test");
        assertEquals(ek, building.addFloor(ek),"Error in adding floor");
    }
} 