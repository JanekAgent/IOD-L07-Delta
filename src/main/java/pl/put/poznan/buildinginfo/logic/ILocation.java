package pl.put.poznan.buildinginfo.logic;

/**
 * The ILocation interface represents a location in a building.
 * It provides methods to calculate the area and volume of the location.
 */
public interface ILocation {
    /**
     * Calculates the area of the location.
     *
     * @return the area of the location
     */
    double calculateArea();

    /**
     * Calculates the volume of the location.
     *
     * @return the volume of the location
     */
    double calculateVolume();
}
