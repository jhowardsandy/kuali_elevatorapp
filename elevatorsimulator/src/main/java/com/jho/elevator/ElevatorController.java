package com.jho.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    int MIN_FLOOR = 1;
    int MAX_FLOOR = 1;

    int DIRECTION_DOWN = 0;
    int DIRECTION_UP = 1;

    private List<Elevator> elevators;

    public ElevatorController(int count, int floors) {
        initializeElevators(count, floors);
    }


    public void initializeElevators(int count, int floors) {
        MAX_FLOOR = floors;

        //For now we will assume all elevators are starting at first floor in online state
        elevators = new ArrayList<Elevator>();
        for (int i = 0; i < count; i++) {
            elevators.add(new Elevator(1, true));
        }
    }

    /**
     * Finds the nearest AVAILABLE elevator that matches the request from the requested FLOOR
     * @param direction
     * @return if an elevator is able to pickup request
     */
    //TODO: Complete this method
    public boolean requestElevator(int direction, int floor) {

        return true;
    }

    /**
     * This will attempt to move an elevator to the specified floor
     * @param id - the ID of the elevator to move
     * @param floor - the floor the elevator should move to
     * @return
     */
    //TODO: Comlete this method
    public boolean moveElevator(int id, int floor) {
        return true;
    }

    /**
     * Prints out the current list of elevators and where they are at, including online/offline
     */
    //TODO: Complete this method
    public void showElevatorState() {
        if (elevators == null) {
            //Throw exception here
            System.out.println("Elevator list is empty, cannot print list");
        }
        for (Elevator e : elevators) {

        }
    }

    /**
     * This will "service" the specified elevator, resetting current trip count and
     * setting it back in online mode
     * @param elevator
     * @return
     */
    public Elevator serviceElevator(Elevator elevator) {
        elevator.setFloorsTraveled(0);
        elevator.setOnline(true);
        return elevator;
    }



}
