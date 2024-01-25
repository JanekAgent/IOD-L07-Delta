package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class BuildingTest{
    private Building building;
    private List<Floor> floors;

    @Mock
    private Floor floor1Mock;
    @Mock
    private Floor floor2Mock;
    @Mock
    private Floor floor3Mock;
    @Mock
    private Floor floor4Mock;
    @Mock
    private Floor floor5Mock;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        floors= new ArrayList<>();
        floors.add(floor1Mock);
        floors.add(floor2Mock);
        floors.add(floor3Mock);
        floors.add(floor4Mock);
        floors.add(floor5Mock);

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
        assertEquals(floor, building.addFloor(floor), "The added floor should be equal to the floor returned by the method.");
    }
    @Test
    void calculateVolumeTest(){
        assertEquals(241, building.calculateVolume(), "The calculated volume should be equal to 241.");
    }

    @Test
    void calculateVolumeTest2() {

        when(floor1Mock.calculateVolume()).thenReturn(100.0);
        when(floor2Mock.calculateVolume()).thenReturn(200.0);
        when(floor3Mock.calculateVolume()).thenReturn(300.0);
        when(floor4Mock.calculateVolume()).thenReturn(400.0);
        when(floor5Mock.calculateVolume()).thenReturn(500.0);

        
        assertEquals(1741, building.calculateVolume(), "The calculated volume should be equal to 1741.");


        verify(floor1Mock).calculateVolume();
        verify(floor2Mock).calculateVolume();
        verify(floor3Mock).calculateVolume();
        verify(floor4Mock).calculateVolume();
        verify(floor5Mock).calculateVolume();
    }

    @Test
    void calculateAreaTest(){
        assertEquals(121, building.calculateArea(), "The calculated area should be equal to 121.");
    }
    @Test
    void calcluateLightPowerDensityTest(){
        assertEquals(2.9834710743801653, building.calculateAverageLightingPowerDensity(), "The calculated average lighting power density should be equal to 2.9834710743801653.");
    }
    @Test
    void getFloorByIdTest(){
        Floor floor = new Floor(123, null);
        building.addFloor(floor);
        assertEquals(floor, building.getFloorById(123), "The retrieved floor should be equal to the floor added to the building.");
    }
    @Test 
    void deleteFloor(){
        Floor floor = new Floor(123, null);
        building.addFloor(floor);
        assertEquals(floor, building.getFloorById(123), "The retrieved floor should be equal to the floor added to the building.");
        building.deleteFloor(123);
        assertEquals(null, building.getFloorById(123), "The retrieved floor should be null after deleting the floor.");
    }
    
}
