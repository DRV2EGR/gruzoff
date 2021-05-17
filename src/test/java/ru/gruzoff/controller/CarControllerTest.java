package ru.gruzoff.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.gruzoff.dto.CarDto;
import ru.gruzoff.dto.CarTypeDto;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.service.CarService;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {CarController.class})
@ExtendWith(SpringExtension.class)
public class CarControllerTest {
    @Autowired
    private CarController carController;

    @MockBean
    private CarService carService;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllCarsInfo() throws Exception {
        when(this.carService.getAllCars()).thenReturn(new ArrayList<CarWithCarValidDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/cars/private/all_cars");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllCarsInfo2() throws Exception {
        when(this.carService.getAllCars()).thenReturn(new ArrayList<CarWithCarValidDto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/cars/private/all_cars");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testDeleteCar() throws Exception {
        when(this.carService.disvalidCarById(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/v1/api/cars/private/delete_car");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("car_id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }

    @Test
    public void testGetAllCarTypes() throws Exception {
        when(this.carService.getAllCarTypes()).thenReturn(new ArrayList<CarTypeDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/cars/get_car_types");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllCarTypes2() throws Exception {
        when(this.carService.getAllCarTypes()).thenReturn(new ArrayList<CarTypeDto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/cars/get_car_types");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testDeleteCar2() throws Exception {
        when(this.carService.disvalidCarById(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/v1/api/cars/private/delete_car");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("car_id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"ERROR\"}")));
    }

    @Test
    public void testGetAllCars() throws Exception {
        when(this.carService.getAllValidCars()).thenReturn(new ArrayList<CarDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/cars/");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllCars2() throws Exception {
        when(this.carService.getAllValidCars()).thenReturn(new ArrayList<CarDto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/cars/");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }
}

