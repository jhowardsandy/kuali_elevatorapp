package com.jho.elevator;

public class Elevator {

    private int elevatorId;

    private boolean online;
    private boolean moving;
    private int movingDirection;

    private int currentFloor;
    private int destinationFloor;

    private int floorsTraveled;
    //This is a number showing ALL floors traveled
    private int allFloorsTraveled;

    private int tripsMade;

    public Elevator(int startingFloor, boolean state) {
        this.currentFloor = startingFloor;
        this.online = state;
        this.moving = false;
        this.movingDirection = 0;
        this.destinationFloor = 0;
        this.floorsTraveled = 0;
        this.allFloorsTraveled = 0;
        this.tripsMade = 0;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
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
