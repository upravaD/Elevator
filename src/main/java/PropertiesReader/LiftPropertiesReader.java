package PropertiesReader;

public class LiftPropertiesReader extends PropertiesReader {

    private final int CAPACITY;
    private final int START_FLOOR;

    public LiftPropertiesReader() {
        CAPACITY = Integer.parseInt(properties.getProperty("lift.capacity"));
        START_FLOOR = Integer.parseInt(properties.getProperty("lift.start_floor"));
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public int getSTART_FLOOR() {
        return START_FLOOR;
    }
}
