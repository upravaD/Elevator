package PropertiesReader;

public class LiftPropertiesReader extends PropertiesReader {

    private final int MAX_CAPACITY;
    private final int START_FLOOR;

    public LiftPropertiesReader() {
        MAX_CAPACITY = Integer.parseInt(properties.getProperty("lift.capacity"));
        START_FLOOR = Integer.parseInt(properties.getProperty("lift.start_floor"));
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public int getSTART_FLOOR() {
        return START_FLOOR;
    }
}
