package com.jho.elevator;

public class ElevatorSimulator {

    //TODO: Accept parameters for the number of elevators, floors, etc.....
    public static void main(String args[]) {

        ElevatorController controller = new ElevatorController(5, 5);
        controller.showElevatorState();
    }

}
