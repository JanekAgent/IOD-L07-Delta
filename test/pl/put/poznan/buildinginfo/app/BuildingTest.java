package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.unit.jupiter.api.Assertions.*;
class BuildingTest{
    private building building;
    @BeforeEach
    void setUp(){
        building = new building("test", 1, null);
    }
    @Test
    void testGetFloor(){
        assertEquals(null, building.getFloor(1));
    }
    @Test
    void testSetFloors(){
        building.setFloors(null);
        assertEquals(null, building.getFloors());
    }
    @Test
    void testGetName(){
        assertEquals("test", building.getName());
    }
} 