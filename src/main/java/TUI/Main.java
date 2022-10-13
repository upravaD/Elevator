package TUI;

import Elevator.Building;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.getHead();

        Building building = new Building();

        ElevatorManager elevatorManager = new ElevatorManager(building);

        int x = building.getFLOOR_COUNT()*2;
        while (x > 0) {
            elevatorManager.showBuilding();
            System.out.println();
            x--;
        }
    }
}
