package com.jho.elevatorapp.elevatorservice.service;

import com.jho.elevatorapp.elevatorservice.model.Elevator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElevatorControllerService {

    int MIN_FLOOR = 1;
    int MAX_FLOOR = 1;

    int DIRECTION_DOWN = 0;
    int DIRECTION_UP = 1;

    private List<Elevator> elevators;

    public ElevatorControllerService() {
        initializeElevators(5, 25);
    }

    public ElevatorControllerService(int count, int floors) {
        initializeElevators(count, floors);
    }


    public void initializeElevators(int count, int floors) {
        MAX_FLOOR = floors;

        //For now we will assume all elevators are starting at first floor in online state
        elevators = new ArrayList<Elevator>();
        for (int i = 0; i < count; i++) {
            elevators.add(new Elevator(i, 1, true));
        }
    }

    /**
     * Finds the nearest AVAILABLE elevator that matches the request from the requested FLOOR
     * @param direction
     * @return if an elevator is able to pickup request
     */
    //TODO: Complete this method
    public int requestElevator(int direction, int floor) {

        //TODO: Implement direction checking. Currently doesn't care which direction the user cares to go
        Elevator closestElevator;

        //First just find the closest elevator, we will include moving ones later
        //First see if any exist on the requesting floor
        closestElevator = elevators.get(0);
        int closestElevatorDistance = Math.abs(floor - closestElevator.getCurrentFloor());

        for (Elevator e : elevators) {
            if (e.isOnline()) {
                if (e.isMoving()) {
                    if (e.getCurrentFloor() > floor) {
                        if (e.getMovingDirection() == 1) {
                            //Elevator is moving towards, check
                            if (Math.abs(e.getCurrentFloor() - floor) < closestElevatorDistance) {
                                closestElevator = e;
                            }
                        }
                    } else {
                        if (e.getMovingDirection() == 2) {
                            if (Math.abs(e.getCurrentFloor() - floor) < closestElevatorDistance) {
                                closestElevator = e;
                            }
                        }
                    }
                }
                //elevator is not moving, check current floor
                else {
                    if (Math.abs(e.getCurrentFloor() - floor) < closestElevatorDistance) {
                        closestElevator = e;
                    }
                }
            }
        }

        System.out.println(String.format("Found closest available elevator [%d]", closestElevator.getElevatorId()));

        //Now move the closest available elevator to the requested floor
        moveElevator(closestElevator.getElevatorId(), floor);
        return closestElevator.getElevatorId();
    }

    //This will move the closes elevator to the current floor and transport to destination floor
    public synchronized void transportPassengers(int currentFloor, int destinationFloor) {
        elevators.get(requestElevator(0, currentFloor)).moveElevator(destinationFloor);
    }

    public void transportPassengers(int currentFloor, int[] floors) {
        //TODO: Complete this method

        //As an elevator can have passengers that need to go to multiple floors, we should correctly stop and drop off at
        //each of these floors on our way
    }

    /**
     * This will attempt to move an elevator to the specified floor
     * @param id - the ID of the elevator to move
     * @param floor - the floor the elevator should move to
     * @return
     */
    public boolean moveElevator(int id, int floor) {
        if (id > elevators.size() - 1) {
            System.out.println("Unable to move elevator, invalid elevator requested");
            return false;
        }

        if (floor > MAX_FLOOR) {
            System.out.println("Unable to move elevator, invalid floor requested");
            return false;
        }

        elevators.get(id).moveElevator(floor);

        return true;
    }

    /**
     * Prints out the current list of elevators and where they are at, including online/offline
     */
    public void showElevatorState() {
        if (elevators == null) {
            //Throw exception here
            System.out.println("Elevator list is empty, cannot print list");
        }
        for (Elevator e : elevators) {
            System.out.println(String.format("Elevator id: [%d] : Current Floor: [%d] : Online [%s] : Moving [%s] : " +
                            "Trips Made [%d] : Floors Traveled [%d]",
                    e.getElevatorId(), e.getCurrentFloor(), e.isOnline(), e.isMoving(), e.getTripsMade(), e.getFloorsTraveled()));
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
        elevator.setDoorState(0);
        elevator.setTripsMade(0);
        return elevator;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

}
