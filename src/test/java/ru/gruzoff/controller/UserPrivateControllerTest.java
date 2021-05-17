package ru.gruzoff.controller;

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
import ru.gruzoff.service.ClassToDtoService;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {UserPrivateController.class})
@ExtendWith(SpringExtension.class)
public class UserPrivateControllerTest {
    @MockBean
    private ClassToDtoService classToDtoService;

    @Autowired
    private UserPrivateController userPrivateController;

    @MockBean
    private UserService userService;

    @Test
    public void testGetFilterredOrders() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/user/private/orders");
        MockMvcBuilders.standaloneSetup(this.userPrivateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetFilterredOrders2() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/v1/api/user/private/orders");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.userPrivateController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSetComment() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/user/private/set_comment");
        MockMvcBuilders.standaloneSetup(this.userPrivateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSetComment2() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/v1/api/user/private/set_comment");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.userPrivateController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

