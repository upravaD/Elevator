package TUI;

import Elevator.Building;
import Elevator.Lift;

public class Main {



    public static void main(String[] args) {

        System.out.println("==========================");
        System.out.println("OFFICE ELEVATOR SIMULATION");
        System.out.println("==========================\n");

        Building building = new Building();
        Lift lift = new Lift();

        ElevatorManager elevatorManager = new ElevatorManager(building);
        elevatorManager.showBuilding();

    }
}
