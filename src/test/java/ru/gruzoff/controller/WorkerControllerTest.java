package ru.gruzoff.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.payload.DateFilterDtoPayload;
import ru.gruzoff.service.OrderService;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {WorkerController.class})
@ExtendWith(SpringExtension.class)
public class WorkerControllerTest {
    @MockBean
    private OrderService orderService;

    @MockBean
    private UserService userService;

    @Autowired
    private WorkerController workerController;

    @Test
    public void testShowRelevantOrderByDateDriver() throws Exception {
        when(this.orderService.showReleventOrdersOnDay((Date) any(), anyInt())).thenReturn(new ArrayList<OrderDto>());

        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate2(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate1(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        String content = (new ObjectMapper()).writeValueAsString(dateFilterDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/api/worker/driver/show_relevant_orders_on_day")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.workerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testShowRelevantOrderByDateLoader() throws Exception {
        when(this.orderService.showReleventOrdersOnDay((Date) any(), anyInt())).thenReturn(new ArrayList<OrderDto>());

        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate2(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate1(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        String content = (new ObjectMapper()).writeValueAsString(dateFilterDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/api/worker/loader/show_relevant_orders_on_day")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.workerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }
}

