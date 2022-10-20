package UI;

import Elevator.*;
import Elevator.Building.Floor.Human;

public class ElevatorManager {

    private Lift lift;
    private Building building;
    private String dir;
    Direction direction;
    Menu menu;

    public ElevatorManager(Building building) {
        lift = new Lift();
        this.building = building;
        direction = new Direction();
        menu = new Menu();
        dir = direction.up;
    }

    public void showBuilding(){
        menu.getGeneralView();
        System.out.println(direction.underLine());

        for (int i = 0; i < building.getFLOOR_COUNT(); i++) {
            System.out.print("︙ " + "\033[0;97m" + building.getFloorsList().get(i).getFLOOR_ID() + "\u001B[0m");
            System.out.print(" ︙ " + building.getRightFloorList(i));

            if (i == lift.getCurrentFloor()-1) {
                System.out.print(" ︙ " + dir + " ︙");
                liftMoving();
            }
            System.out.println();
            System.out.println(direction.underLine());
        }

        if (dir.equals(direction.up)) {
            lift.moveUp();
        } else {
            lift.moveDown();
        }

        if (lift.getCurrentFloor() == building.getFLOOR_COUNT()) {
            changeDirection();
        }
        if (lift.getCurrentFloor() == 1) {
            changeDirection();
        }
    }

    public void liftMoving() {
        lift.humanOut();

        if ( !(building
                .getFloorsList()
                .get(lift.getCurrentFloor() - 1)
                .getHumanQueueList()
                .isEmpty())) {
            if (dir.equals(direction.up)) {
                lift.humanInUP(building);
            } else {
                lift.humanInDOWN(building);
            }
        }

        for (Human human : lift.getHumanInList()) {
            System.out.print(" " + human.getRightFloor() + " ");
        }
        System.out.print("︙");
    }

    private void changeDirection(){
        if (dir.equals(direction.up)) {
            dir = direction.down;
        } else {
            dir = direction.up;
        }
    }
}
