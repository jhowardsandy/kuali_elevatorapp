package com.jho.elevator;

public class ElevatorSimulator {

    //TODO: Accept parameters for the number of elevators, floors, etc.....
    public static void main(String args[]) {

        ElevatorController controller = new ElevatorController(5, 5);
        controller.showElevatorState();

        controller.moveElevator(1, 4);
        controller.moveElevator(3, 5);
        controller.moveElevator(2, 2);

        //Move an incorrect elevator and validate error
        controller.moveElevator(7, 1);
        //Move to an incorrect floor and validate error
        controller.moveElevator(1, 9999);

        controller.showElevatorState();

    }

}
