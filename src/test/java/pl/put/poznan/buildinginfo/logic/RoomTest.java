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
        assertEquals(0.75, room.calculateLightingPowerDensity(), "Incorrect lighting power density calculation");
        
    }
    
    @Test
    void getIdTest(){
        assertEquals(1, room.getId(), "Incorrect ID");
    }
    @Test 
    void getNameTest(){
        assertEquals("Test", room.getName(), "Incorrect name");
    }
    @Test 
    void getAreaTest(){
        assertEquals(20, room.getArea(), "Incorrect area");
    }
    @Test
    void getCubeTest(){
        assertEquals(30, room.getCube(), "Incorrect cube");
    }
    @Test
    void getHeatingEnergyConsumptionTest(){
        assertEquals(40, room.getHeatingEnergyConsumption(), "Incorrect heating energy consumption");
    }
    @Test
    void setIdTest(){
        room.setId(9999);
        assertEquals(9999, room.getId(), "Incorrect ID after setting");
    }
    @Test
    void setNameTest(){
        room.setName("Testingsetname");
        assertEquals("Testingsetname", room.getName(), "Incorrect name after setting");
    }
    @Test
    void setAreaTest(){
        room.setArea(3000);
        assertEquals(3000, room.getArea(), "Incorrect area after setting");
    }
    @Test
    void setCubeTest(){
        room.setCube(4030);
        assertEquals(4030, room.getCube(), "Incorrect cube after setting");
    }
    @Test
    void setLightingPowerTest(){
        room.setLightingPower(3020);
        assertEquals(3020, room.getLightingPower(), "Incorrect lighting power after setting");
    }
    @Test
    void setHeatingEnergyConsumptionTest(){
        room.setHeatingEnergyConsumption(57);
        assertEquals(57, room.getHeatingEnergyConsumption(), "Incorrect heating energy consumption after setting");

    }
}
