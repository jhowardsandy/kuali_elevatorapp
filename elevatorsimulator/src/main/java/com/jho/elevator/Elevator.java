package com.jho.elevator;

public class Elevator {

    private int elevatorId;

    private boolean online;
    private boolean moving;
    private int movingDirection;

    private int doorState = 0;

    private int currentFloor;
    private int destinationFloor;

    private int floorsTraveled;
    //This is a number showing ALL floors traveled
    private int allFloorsTraveled;

    private int tripsMade;

    public static final int MOVING_DIRECTION_NONE = 0;
    public static final int MOVING_DIRECTION_DOWN = 1;
    public static final int MOVING_DIRECTION_UP = 2;

    private static final int DOOR_STATE_CLOSED = 0;
    private static final int DOOR_STATE_OPEN = 1;

    public Elevator(int elevatorId, int startingFloor, boolean state) {
        this.elevatorId = elevatorId;
        this.currentFloor = startingFloor;
        this.online = state;
        this.moving = false;
        this.movingDirection = 0;
        this.destinationFloor = 0;
        this.floorsTraveled = 0;
        this.allFloorsTraveled = 0;
        this.tripsMade = 0;
    }

    public void moveElevator(int floor) {

        if (!online) {
            System.out.println(String.format("Elevator [%d] is not online, cannot move", elevatorId));
            return;
        }

        if (currentFloor == floor) {
            System.out.println("Elevator [%d] is already at it's destination");
            return;
        }

        closeDoor();
        setMoving(true);

        tripsMade++;

        if (currentFloor > floor) {
            setMovingDirection(MOVING_DIRECTION_DOWN);
            while (currentFloor != floor) {
                System.out.println(String.format("Elevator [%d] moving from floor [%d] to [%d]", elevatorId, currentFloor, currentFloor -1 ));
                floorsTraveled++;
                currentFloor--;
            }
        }

        if (currentFloor < floor) {
            setMovingDirection(MOVING_DIRECTION_UP);
            while (currentFloor != floor) {
                System.out.println(String.format("Elevator [%d] moving from floor [%d] to [%d]", elevatorId, currentFloor, currentFloor + 1 ));
                floorsTraveled++;
                currentFloor++;
            }
        }

        System.out.println(String.format("Elevator [%d] has arrivated at destniation floor [%d]", elevatorId, currentFloor));

        setMoving(false);
        setMovingDirection(MOVING_DIRECTION_NONE);
        openDoor();

        if (tripsMade >= 100) {
            setOnline(false);
        }

    }

    public void openDoor() {
        System.out.println(String.format("Elevator [%d] door opening", elevatorId));
        setDoorState(DOOR_STATE_OPEN);
    }

    public void closeDoor() {
        System.out.println(String.format("Elevator [%d] door closing", elevatorId));
        setDoorState(DOOR_STATE_CLOSED);
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getDoorState() {
        return doorState;
    }

    public void setDoorState(int doorState) {
        this.doorState = doorState;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getFloorsTraveled() {
        return floorsTraveled;
    }

    public void setFloorsTraveled(int floorsTraveled) {
        this.floorsTraveled = floorsTraveled;
    }

    public int getAllFloorsTraveled() {
        return allFloorsTraveled;
    }

    public void setAllFloorsTraveled(int allFloorsTraveled) {
        this.allFloorsTraveled = allFloorsTraveled;
    }

    public int getTripsMade() {
        return tripsMade;
    }

    public void setTripsMade(int tripsMade) {
        this.tripsMade = tripsMade;
    }

    public int getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(int movingDirection) {
        this.movingDirection = movingDirection;
    }
}
