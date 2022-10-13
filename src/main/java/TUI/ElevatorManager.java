package TUI;

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
        //showBuilding();
    }

    public void showBuilding(){

        menu.getGeneralView();
        System.out.println(direction.underLine());

        for (int i = 0; i < building.getFLOOR_COUNT(); i++) {

            System.out.print("︙ " + building.getFloorsList().get(i).getFLOOR_ID());
            System.out.print(" ︙ " + building.getRightFloorList(i));

            if (i == lift.getCurrentFloor()-1) {
                System.out.print(" ︙ " + dir + " ︙ ");
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
            System.out.print("changeDown");
        }

        if (lift.getCurrentFloor() == 1) {
            changeDirection();
            System.out.print("changeUp");
        }
    }

    public void liftMoving() {

        if (!(building.getFloorsList().get(lift.getCurrentFloor() - 1).getHumanQueueList().isEmpty())) {
            lift.humanOut(building);
            if (dir.equals(direction.up)) {
                lift.humanInUP(building);
            } else {
                lift.humanInDOWN(building);
            }
        } else {
            lift.humanOut(building);
            System.out.print("empty");
        }

        //вывод
        System.out.print("︙");
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
