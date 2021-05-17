package ru.gruzoff.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
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
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.service.CarService;
import ru.gruzoff.service.ManagerService;

@ContextConfiguration(classes = {ManagerController.class})
@ExtendWith(SpringExtension.class)
public class ManagerControllerTest {
    @MockBean
    private CarService carService;

    @Autowired
    private ManagerController managerController;

    @MockBean
    private ManagerService managerService;

    @Test
    public void testGetOrdersToAccept() throws Exception {
        when(this.managerService.getOrdersToAccept()).thenReturn(new ArrayList<OrderDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/manager/get_orders_to_accept");
        MockMvcBuilders.standaloneSetup(this.managerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetOrdersToAccept2() throws Exception {
        when(this.managerService.getOrdersToAccept()).thenReturn(new ArrayList<OrderDto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/manager/get_orders_to_accept");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.managerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testAcceptOrder() throws Exception {
        doNothing().when(this.managerService).acceptById(anyLong(), anyInt());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/manager/accept_order");
        MockHttpServletRequestBuilder paramResult = getResult.param("orderId", String.valueOf(1L));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("status", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.managerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }

    @Test
    public void testChangeCarValid() throws Exception {
        doNothing().when(this.carService).changeCarValid(anyLong(), anyInt(), anyString());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/manager/change_car_valid");
        MockHttpServletRequestBuilder paramResult = getResult.param("carId", String.valueOf(1L)).param("reason", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("valid", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.managerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }
}

