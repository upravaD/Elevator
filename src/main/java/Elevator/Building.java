package Elevator;

import PropertiesReader.BuildingPropertiesReader;
import PropertiesReader.FloorPropertiesReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {

    private final int FLOOR_COUNT;
    private List<Floor> floorsList;

    public List<Floor> getFloorsList() {
        return floorsList;
    }

    public int getFLOOR_COUNT() {
        return FLOOR_COUNT;
    }

    public Building() {

        BuildingPropertiesReader bpr = new BuildingPropertiesReader();
        FLOOR_COUNT = new Random().nextInt(bpr.getMIN_FLOORS(), bpr.getMAX_FLOORS() + 1);

        floorsList = new ArrayList<>();
        for (int i = 1; i <= FLOOR_COUNT; i++) {
            floorsList.add(new Floor(i));
        }
    }

    public class Floor {

        private final int FLOOR_ID;
        private int humanQueueCount;
        private List<Human> humanQueueList;

        public int getFLOOR_ID() {
            return FLOOR_ID;
        }
        public List<Human> getHumanQueueList() {
            return humanQueueList;
        }

        public Floor(int floorId) {
            FLOOR_ID = floorId;
            generateQueue();
        }

        public void generateQueue() {

            FloorPropertiesReader fpr = new FloorPropertiesReader();
            humanQueueCount = new Random().nextInt(fpr.getMIN_QUEUE(), fpr.getMAX_QUEUE() + 1);

            humanQueueList = new ArrayList<>();
            for (int i = 0; i < humanQueueCount; i++) {
                humanQueueList.add(new Human(FLOOR_ID));
            }
        }

        public class Human {

            private int currentFloor;
            private int neededFloor;

            public Human(int currentFloor) {
                this.currentFloor = currentFloor;
                generateNeededFloor();
            }

            public int getNeededFloor() {
                return neededFloor;
            }

            private void generateNeededFloor() {
                do {
                    neededFloor = new Random().nextInt(1, FLOOR_COUNT + 1);
                } while (currentFloor == neededFloor);
            }
        }
    }
}
