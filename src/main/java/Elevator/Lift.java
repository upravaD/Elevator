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

    public void humanInUP(Building building) {

        if ((getCapacity() - getHumanInList().size()) > 0) {

            for (int i = 0; i < building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().size(); i++) {

                if (building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().get(i).getRightFloor() > getCurrentFloor()) {
                    getHumanInList().add(building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().get(i));
                }
                if ((getCapacity() - getHumanInList().size()) == 0) {
                    System.out.print("break");
                    break;
                }
            }

            for (Human number : getHumanInList()) {
                building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().remove(number);
            }

            System.out.print("take");
            System.out.print((getCapacity() - getHumanInList().size()));

        } else {

            System.out.print("nobody");
            System.out.print((getCapacity() - getHumanInList().size()));
        }
    }

    public void humanInDOWN(Building building) {

        if ((getCapacity() - getHumanInList().size()) > 0) {

            for (int i = 0; i < building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().size(); i++) {

                if (building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().get(i).getRightFloor() < getCurrentFloor()) {
                    getHumanInList().add(building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().get(i));
                }
                if ((getCapacity() - getHumanInList().size()) == 0) {
                    System.out.print("break");
                    break;
                }
            }

            for (Human number : getHumanInList()) {
                building.getFloorsList().get(getCurrentFloor() - 1).getHumanQueueList().remove(number);
            }

            System.out.print("take");
            System.out.print((getCapacity() - getHumanInList().size()));

        } else {

            System.out.print("nobody");
            System.out.print((getCapacity() - getHumanInList().size()));
        }
    }

    public void humanOut(Building building) {

        for (int i = 0; i < getHumanInList().size(); i++) {
            getHumanInList().removeIf(o -> o.getRightFloor() == getCurrentFloor());
        }
    }

    public void moveUp(){
        setCurrentFloor(getCurrentFloor()+1);
    }

    public void moveDown(){
        setCurrentFloor(getCurrentFloor()-1);
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
