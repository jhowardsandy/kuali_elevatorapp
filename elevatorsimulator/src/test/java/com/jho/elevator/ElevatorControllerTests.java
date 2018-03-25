package com.jho.elevator;

import org.junit.Assert;
import org.junit.Test;

public class ElevatorControllerTests {

    @Test
    public void testSimpleElevatorControllerInitNotNull() {
        ElevatorController controller = new ElevatorController(3, 12);

        Assert.assertNotNull(controller);
    }

    @Test
    public void testSimpleElevtorControllerElevatorCount() {
        ElevatorController controller = new ElevatorController(3, 12);

        Assert.assertTrue(controller.getElevators().size() == 3);
    }


    @Test
    public void testSimpleElevatorControllerFloorCount() {
        ElevatorController controller = new ElevatorController(3, 12);

        Assert.assertTrue(controller.MAX_FLOOR == 12);
    }

    @Test
    public void testSimpleMoveElevator() {
        ElevatorController controller = new ElevatorController(3, 12);
        controller.moveElevator(2, 7);

        Assert.assertTrue(controller.getElevators().get(2).getCurrentFloor() == 7);
    }

    @Test
    public void testSimpleGetBestAvailableElevator() {
        ElevatorController controller = new ElevatorController(3, 12);
        controller.moveElevator(2, 7);

        Assert.assertTrue(controller.requestElevator(1, 5) == 2);
    }

    @Test
    public void testSimpleGetBestAvailableElevatorSameFloor() {
        ElevatorController controller = new ElevatorController(3, 12);
        controller.moveElevator(2, 7);

        Assert.assertTrue(controller.requestElevator(1, 7) == 2);
    }

    @Test
    public void testSimpleTransportPassengers() {
        ElevatorController controller = new ElevatorController(3, 12);
        controller.moveElevator(2, 7);
        controller.transportPassengers(7, 11);

        Assert.assertTrue(controller.getElevators().get(2).getCurrentFloor() == 11);
    }

    @Test
    public void testSimpleAssertElevatorServiceAtOneHundredTrips() {
        ElevatorController controller = new ElevatorController(3, 12);
        for (int i = 0; i < 51; i++) {
            controller.moveElevator(2, 12);
            controller.moveElevator(2, 1);
        }

        Assert.assertFalse(controller.getElevators().get(2).isOnline());
    }

    @Test
    public void testServicedElevatorWorkingState() {
        ElevatorController controller = new ElevatorController(3, 12);
        controller.getElevators().get(2).setOnline(false);
        controller.getElevators().get(2).setFloorsTraveled(2562);
        controller.getElevators().get(2).setTripsMade(100);

        controller.serviceElevator(controller.getElevators().get(2));

        Elevator e = controller.getElevators().get(2);
        Assert.assertTrue(e.isOnline());
        Assert.assertTrue(e.getTripsMade() == 0);
        Assert.assertTrue(e.getFloorsTraveled() == 0);
    }

}
