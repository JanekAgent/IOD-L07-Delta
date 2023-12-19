package pl.put.poznan.buildinginfo.logic;

import java.util.List;

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
public class Floor {
    int id;
    String name;
    List <Room> rooms;
    public Floor(int id, String name) {
        this.id = id;
        this.name = name;
    }
    void setName(String name) {
        this.name = name;
    }
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    

}
