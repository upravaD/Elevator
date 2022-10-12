package Elevator;

import java.util.ArrayList;
import java.util.List;
import Elevator.Building.Floor.Human;
import PropertiesReader.LiftPropertiesReader;

public class Lift {

    private final int capacity;
    private List<Human> humanInList;
    private int currentFloor;

    public Lift() {

        LiftPropertiesReader lpr = new LiftPropertiesReader();
        capacity = lpr.getCAPACITY();
        currentFloor = lpr.getSTART_FLOOR();
        humanInList = new ArrayList<>(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Human> getHumanInList() {
        return humanInList;
    }
    public void setHumanInList(List<Human> humanInList) {
        this.humanInList = humanInList;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
