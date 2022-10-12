package TUI;

import Elevator.Building;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        Building building = new Building();

        ElevatorManager elevatorManager = new ElevatorManager(building);

    }
}
