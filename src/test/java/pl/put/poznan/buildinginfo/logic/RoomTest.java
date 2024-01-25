package pl.put.poznan.buildinginfo.logic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RoomTest {
    private Room room;
    @BeforeEach
    void setUp(){
        room=new Room(1,"Test",20,30,15,40);
    }
    
    @Test
    void calcluateLightPowerDensityTest(){
        assertEquals(0.75, room.calculateLightingPowerDensity());
        
    }
    
    @Test
    void getIdTest(){
        assertEquals(1, room.getId());
    }
    @Test 
    void getNameTest(){
        assertEquals("Test", room.getName());
    }
    @Test 
    void getAreaTest(){
        assertEquals(20, room.getArea());
    }
    @Test
    void getCubeTest(){
        assertEquals(30, room.getCube());
    }
    @Test
    void getHeatingEnergyConsumptionTest(){
        assertEquals(40, room.getHeatingEnergyConsumption());
    }
    @Test
    void setIdTest(){
        room.setId(9999);
        assertEquals(9999, room.getId());
    }
    @Test
    void setNameTest(){
        room.setName("Testingsetname");
        assertEquals("Testingsetname", room.getName());
    }
    @Test
    void setAreaTest(){
        room.setArea(3000);
        assertEquals(3000, room.getArea());
    }
    @Test
    void setCubeTest(){
        room.setCube(4030);
        assertEquals(4030, room.getCube());
    }
    @Test
    void setLightingPowerTest(){
        room.setLightingPower(3020);
        assertEquals(3020, room.getLightingPower());
    }
    @Test
    void setHeatingEnergyConsumptionTest(){
        room.setHeatingEnergyConsumption(57);
        assertEquals(57, room.getHeatingEnergyConsumption());

    }
}
