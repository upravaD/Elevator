package PropertiesReader;

public class FloorPropertiesReader extends PropertiesReader {

    private final int MIN_QUEUE;
    private final int MAX_QUEUE;

    public FloorPropertiesReader() {
        MIN_QUEUE = Integer.parseInt(properties.getProperty("floor.min_queue"));
        MAX_QUEUE = Integer.parseInt(properties.getProperty("floor.max_queue"));
    }

    public int getMIN_QUEUE() {
        return MIN_QUEUE;
    }

    public int getMAX_QUEUE() {
        return MAX_QUEUE;
    }
}
