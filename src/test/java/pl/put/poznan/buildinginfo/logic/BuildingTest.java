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

    
    
} 