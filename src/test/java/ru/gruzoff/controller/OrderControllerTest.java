package ru.gruzoff.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.Comments;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.Role;
import ru.gruzoff.entity.User;
import ru.gruzoff.payload.DateFilterDtoPayload;
import ru.gruzoff.service.ClassToDtoService;
import ru.gruzoff.service.OrderService;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
public class OrderControllerTest {
    @MockBean
    private ClassToDtoService classToDtoService;

    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllUserOrdersAdmin() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("Activation Code");
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());
        when(this.userService.findUserById(anyLong())).thenReturn(user);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/orders/admin/orders");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetOrderById() throws Exception {
        when(this.orderService.getOrderById(anyLong())).thenReturn(new OrderDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/api/orders/get_order_by_id");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("orderId", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":0,\"customer\":null,\"driver\":null,\"car\":null,\"price\":0.0,\"status\":null,\"orderDetails\":null,\"loaders"
                                        + "\":null,\"extraCustomers\":null}")));
    }

    @Test
    public void testGetUserOrdersBetweenDatesByUserIdAdmin() throws Exception {
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate2(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate1(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        String content = (new ObjectMapper()).writeValueAsString(dateFilterDtoPayload);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders
                .post("/v1/api/orders/admin/orders_filterred_dates");
        MockHttpServletRequestBuilder paramResult = postResult.param("date1", String.valueOf(new Date(1L)));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("id", String.valueOf(1L))
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

