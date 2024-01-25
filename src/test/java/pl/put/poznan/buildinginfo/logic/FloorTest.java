package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
public class FloorTest {
    private Floor floor;
    @BeforeEach
    void setUp(){
        floor = new Floor(0, "test");
        floor.addRoom(new Room(0, "test0", 10, 20, 30, 40));
        floor.addRoom(new Room(1, "test1", 11, 21, 31, 41));
    }
    @Test 
    void addRoomTest(){
        Room room = new Room(2,"test2",1,1,1,1);
        assertEquals(room, floor.addRoom(room));
    }

    @Test
    void calculateVolumeTest(){
        assertEquals(41, floor.calculateVolume());
    }

    @Test
    void calculateAreaTest(){
        assertEquals(21, floor.calculateArea());
    }
    @Test
    void calcluateLightPowerTest(){
        assertEquals(61, floor.calculateLightingPower());
    }
    @Test
    void calcluateLightPowerDensityTest(){
        assertEquals(2.9047619047619047, floor.calculateAverageLightingPowerDensity());
    }
    @Test 
    void getRoomById(){
        Room RoomId = new Room(123, null, 0, 0, 0, 0);
        assertEquals(null, floor.getRoomById(123));
        floor.addRoom(RoomId);
        assertEquals(RoomId, floor.getRoomById(123));
    }
    @Test 
    void deleteRoom(){
        Room RoomId = new Room(123, null, 0, 0, 0, 0);
        floor.addRoom(RoomId);
        assertEquals(RoomId, floor.getRoomById(123));
        floor.deleteRoom(123);
        assertEquals(null, floor.getRoomById(123));

    }
    
}
