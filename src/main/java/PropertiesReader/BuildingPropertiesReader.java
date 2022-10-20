package PropertiesReader;

public class BuildingPropertiesReader extends PropertiesReader {
    private final int MIN_FLOORS;
    private final int MAX_FLOORS;

    public BuildingPropertiesReader() {
        MIN_FLOORS = Integer.parseInt(properties.getProperty("building.min_floors"));
        MAX_FLOORS = Integer.parseInt(properties.getProperty("building.max_floors"));
    }

    public int getMIN_FLOORS() {
        return MIN_FLOORS;
    }

    public int getMAX_FLOORS() {
        return MAX_FLOORS;
    }
}
