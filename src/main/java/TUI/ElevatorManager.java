package TUI;

import Elevator.*;
import Elevator.Building.Floor.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElevatorManager {

    private Lift lift;
    private Building building;

    public ElevatorManager(Building building) {

        lift = new Lift();
        this.building = building;

        showBuilding();
    }

    private void showBuilding(){

        Direction direction = new Direction();

        List<Building.Floor> x = new ArrayList<>(List.copyOf(building.getFloorsList()));
        Collections.reverse(x);
        //Collections.reverse(building.getFloorsList());

        System.out.println("General view of the building: ");
        System.out.println(direction.underLine());

        for (int i = 0; i < building.getFLOOR_COUNT(); i++) {

            if (x.get(i).getFLOOR_ID() < 10) {

                System.out.print("︙  " + x.get(i).getFLOOR_ID());
                System.out.print(" ︙ " + building.getRightFloorList(i));

                if (i == building.getFLOOR_COUNT()-1) {
                    System.out.print(" ︙ " + direction.up + " ︙ ");
                    liftMoving();
                }
                System.out.println();
                System.out.println(direction.underLine());

            } else {

                System.out.print("︙ " + x.get(i).getFLOOR_ID());
                System.out.print(" ︙ " + building.getRightFloorList(i));

                if (i == building.getFLOOR_COUNT()-1) {
                    System.out.print(" ︙ " + direction.down + " ︙ ");
                    liftMoving();
                }
                System.out.println();
                System.out.println(direction.underLine());
            }
        }
    }

    public void liftMoving() {

        if (lift.getHumanInList().isEmpty()) {
            lift.setHumanInList(building
                    .getFloorsList().get(building
                            .getFLOOR_COUNT()-1).getHumanQueueList());
        }

        for (Human human : lift.getHumanInList()) {
            System.out.print(" " + human.getRightFloor() + " ");
        }
        System.out.print(" ︙ ");
        System.out.print(lift.getHumanInList());

    }
}
