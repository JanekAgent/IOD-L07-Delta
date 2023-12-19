package pl.put.poznan.buildinginfo.logic;
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

import java.util.List;

public class Building {
    private String name;
    private String address;

    private List<Floor> floors;
    private int id;

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
        
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

    public int getId() {
        return id;
    }
}
    

    

