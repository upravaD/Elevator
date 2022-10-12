package TUI;

import Elevator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElevatorManager {

    private Lift lift;
    private Building building;

    public ElevatorManager(Building building) {

        lift = new Lift();
        this.building = building;
    }

    public void showBuilding(){

        Collections.reverse(building.getFloorsList());

        System.out.println("Общая картина здания: ");
        System.out.println("============================================");

        for (int i = 0; i < building.getFLOOR_COUNT(); i++) {
            if (building.getFloorsList().get(i).getFLOOR_ID() < 10) {
                System.out.println("  " + building.getFloorsList().get(i).getFLOOR_ID() + " | " + getFloorNeededList(i) + " | ");
                System.out.println("============================================");
            } else {
                System.out.println(" " + building.getFloorsList().get(i).getFLOOR_ID() + " | " + getFloorNeededList(i) + " | ");
                System.out.println("============================================");
            }
        }
        //потоки
    }

    private List<Integer> getFloorNeededList(int floorId){
        List<Integer> neededFloorList = new ArrayList<>();
        for (int i = 0; i < building.getFloorsList().get(floorId).getHumanQueueList().size(); i++) {
            neededFloorList.add(building.getFloorsList().get(floorId).getHumanQueueList().get(i).getNeededFloor());
        }
        return neededFloorList;
    }

}
