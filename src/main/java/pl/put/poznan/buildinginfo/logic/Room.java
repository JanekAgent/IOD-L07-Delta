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
public class Room {
        
    int id;
    String name;
    float area;
    float cube;
    float heating;
    float light;
    public Room(int id, String name, float area, float cube, float heating, float light) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getArea() {
        return area;
    }
    public float getCube() {
        return cube;
    }
    public float getHeating() {
        return heating;
    }
    public float getLight() {
        return light;
    }
    
    public void setName(String name) {
        this.name= name;
    }
    public void setArea(float area) {
        this.area = area;
    }
    public void setCube(float cube) {
        this.cube = cube;
    }
    public void setHeating(float heating) {
        this.heating = heating;
    }
    public void setLight(float light) {
        this.light = light;
    }


}
