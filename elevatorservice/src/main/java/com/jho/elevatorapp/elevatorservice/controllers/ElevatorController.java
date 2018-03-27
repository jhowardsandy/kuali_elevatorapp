package com.jho.elevatorapp.elevatorservice.controllers;

import com.jho.elevatorapp.elevatorservice.model.Elevator;
import com.jho.elevatorapp.elevatorservice.service.ElevatorControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElevatorController {

    @Autowired
    ElevatorControllerService elevatorService;

    @RequestMapping("/initElevators")
    public String initElevatorService(@RequestParam String floorCount,
                                      @RequestParam String elevatorCount) {

        int floors = Integer.parseInt(floorCount);
        int elevators = Integer.parseInt(elevatorCount);

        elevatorService = new ElevatorControllerService(elevators, floors);

        return String.format("Initialized a new Elevator Service with a floor count: [%d] and an elevator count: [%d]", floors, elevators);
    }

    @RequestMapping("/transportPassengers")
    public String transportPassengers(@RequestParam int currentFloor,
                                      @RequestParam int destinationFloor) {
        System.out.println(String.format("Elevator [%d] requested to move passengers to floor [%d]", currentFloor, destinationFloor));
        elevatorService.transportPassengers(currentFloor, destinationFloor);
        return String.format("Elevator [%d] requested to move passengers to floor [%d]", currentFloor, destinationFloor);
    }

    @RequestMapping("/moveElevator")
    public String moveElevator(@RequestParam String elevatorId,
                               @RequestParam String floor) {
        int elevator = Integer.parseInt(elevatorId);
        int destinationFloor = Integer.parseInt(floor);

        System.out.println(String.format("Elevator [%d] requested to move to floor [%d]", elevator, destinationFloor));
        elevatorService.moveElevator(elevator, destinationFloor);
        return String.format("Elevator [%d] requested to move to floor [%d]", elevator, destinationFloor);
}

    @RequestMapping("/requestElevator")
    public String requestElevator(@RequestParam String floor,
                                  @RequestParam String direction) {

        int requestDirection = Integer.parseInt(direction);
        int requestFloor = Integer.parseInt(floor);
        System.out.println(String.format("Floor [%d] requested an elevator to go in the direction [%d]", requestFloor, requestDirection));

        elevatorService.requestElevator(requestDirection, requestFloor);

        return String.format("Floor [%d] requested an elevator to go in the direction [%d]", requestFloor, requestDirection);
    }

    @RequestMapping("/showElevatorState")
    public void showElevatorState() {
        elevatorService.showElevatorState();
    }

    @RequestMapping("/serviceElevator")
    public String serviceElevator(@RequestParam int id) {
        System.out.println(String.format("Servicing elevator with id: [%d]", id));

        try {
            elevatorService.serviceElevator(elevatorService.getElevators().get(id));
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.err.print(String.format("Unable to service elevator with id [%d], said elevator does not exist"));
            System.err.println(ae.getLocalizedMessage());
        }

        return String.format("Completed servicing of elevator with id [%d]", id);
    }

    @RequestMapping(value = "/getElevator")
    Elevator getElevator(@RequestParam int id){
        System.out.println("Getting elevator with ID: "+ id);
        return elevatorService.getElevators().get(id);
    }

    @RequestMapping(value = "/getElevators")
    List<Elevator> getElevators(){
        System.out.println("Getting elevators");
        return elevatorService.getElevators();
    }

    @RequestMapping(value = "/elevatorServiceTest")
    Elevator getElevator(@RequestParam String id){
        int identifier = Integer.parseInt(id);
        System.out.println("Getting elevator with ID: "+ id);
        return elevatorService.getElevators().get(identifier);
    }

}
