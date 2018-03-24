package com.jho.elevator;

public class ElevatorSimulator {

    //TODO: Accept parameters for the number of elevators, floors, etc.....
    public static void main(String args[]) {

        ElevatorController controller = new ElevatorController(10, 125);
        controller.showElevatorState();

        controller.moveElevator(1, 4);
        controller.moveElevator(3, 75);
        controller.moveElevator(2, 2);
        controller.moveElevator(9, 112);

        //Set 8 in maintenance mode due to 100+ trips
        for (int i = 0; i < 51; i++) {
            controller.moveElevator(8, 125);
            controller.moveElevator(8, 1);
        }

        //Move an incorrect elevator and validate error
        controller.moveElevator(7856, 1);
        //Move to an incorrect floor and validate error
        controller.moveElevator(1, 9999);

        //Check the getting of the closes elevator
        controller.requestElevator(1, 4);
        controller.requestElevator(1, 2);
        controller.requestElevator(1, 1);
        controller.requestElevator(1, 3);
        controller.requestElevator(1, 75);

        controller.showElevatorState();

    }

}
