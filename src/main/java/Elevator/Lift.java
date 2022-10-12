package Elevator;

import java.util.ArrayList;
import java.util.List;
import Elevator.Building.Floor.Human;
import PropertiesReader.LiftPropertiesReader;

public class Lift {

    private final int capacity;
    private List<Human> humansInLift;
    private int currentFloor;

    public Lift() {

        LiftPropertiesReader lpr = new LiftPropertiesReader();
        capacity = lpr.getCAPACITY();
        currentFloor = lpr.getSTART_FLOOR();
        humansInLift = new ArrayList<>(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Human> getHumansInLift() {
        return humansInLift;
    }
    public void setHumansInLift(List<Human> humansInLift) {
        this.humansInLift = humansInLift;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
