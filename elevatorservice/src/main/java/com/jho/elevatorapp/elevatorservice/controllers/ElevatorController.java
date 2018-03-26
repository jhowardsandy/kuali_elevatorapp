package com.jho.elevatorapp.elevatorservice.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElevatorController {

    @RequestMapping("/requestElevator")
    public String requestElevator(@RequestParam(name="currentFloor", required = true) String requestFloor,
                                  @RequestParam(name="direction", required = true) String direction) {

        System.out.println(String.format("Floor [%d] requested an elevator to go in the direction [%d]", Integer.parseInt(requestFloor), Integer.parseInt(direction)));

        return String.format("Floor [%d] requested an elevator to go in the direction [%d]", Integer.parseInt(requestFloor), Integer.parseInt(direction));
    }

    @RequestMapping(value = "/personId")
    String getId(@RequestParam String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL without value element";
    }

}
