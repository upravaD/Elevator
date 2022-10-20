package UI;

import Elevator.Building;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean X = false;

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.getHead();

        Building building = new Building();
        ElevatorManager elevatorManager = new ElevatorManager(building);

        boolean y = true;

        while (y) {
            elevatorManager.showBuilding();
            System.out.println();

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < building.getFLOOR_COUNT(); i++) {
                if (building.getRightFloorList(i).isEmpty()) {
                    result.add(i);
                }
            }
            if (result.size() == building.getFLOOR_COUNT() && X) {
                y = false;
                System.err.println("SIMULATION COMPLETE");
            }
        }
    }
}
