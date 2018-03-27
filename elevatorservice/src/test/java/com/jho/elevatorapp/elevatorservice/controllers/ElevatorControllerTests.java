package com.jho.elevatorapp.elevatorservice.controllers;

import com.jho.elevatorapp.elevatorservice.ElevatorserviceApplication;
import com.jho.elevatorapp.elevatorservice.service.ElevatorControllerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElevatorserviceApplication.class)
@WebAppConfiguration
public class ElevatorControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;

    @Autowired
    ElevatorControllerService elevatorService;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        elevatorService.initializeElevators(5, 75);
    }

    @Test
    public void testGetElevatorSimple() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getElevator").param("id", "1");
        this.mockMvc.perform(requestBuilder).andDo(print());
    }

    @Test
    public void testGetElevators() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getElevators");
        MvcResult e = this.mockMvc.perform(requestBuilder).andDo(print()).andReturn();
        System.out.println(e.getResponse().getContentAsString());
    }

    @Test
    public void moveElevatorSimple() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/moveElevator").param("elevatorId", "1").param("floor", "5");
        MvcResult e = this.mockMvc.perform(requestBuilder).andDo(print()).andReturn();
        Assert.assertTrue(e.getResponse().getContentAsString().equals("Elevator [1] requested to move to floor [5]"));
    }

    @Test
    public void testTransportPassengerSimple() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transportPassengers").param("currentFloor", "1").param("destinationFloor", "7");
        MvcResult e = this.mockMvc.perform(requestBuilder).andDo(print()).andReturn();
    }
}
