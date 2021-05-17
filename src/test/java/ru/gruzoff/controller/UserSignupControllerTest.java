package ru.gruzoff.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import ru.gruzoff.dto.UserDto;
import ru.gruzoff.payload.UserDtoPayload;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {UserSignupController.class})
@ExtendWith(SpringExtension.class)
public class UserSignupControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private UserSignupController userSignupController;

    @Test
    public void testSignUpNewCustomer() throws Exception {
        when(this.userService.registerNewCustomer((UserDtoPayload) any()))
                .thenReturn(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/signup/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":0,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":"
                                        + "\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"role\":\"Role\"}")));
    }

    @Test
    public void testSignUpNewDriver() throws Exception {
        when(this.userService.registerNewDriver((UserDtoPayload) any()))
                .thenReturn(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/signup/driver")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":0,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":"
                                        + "\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"role\":\"Role\"}")));
    }

    @Test
    public void testSignUpNewLoader() throws Exception {
        when(this.userService.registerNewLoader((UserDtoPayload) any()))
                .thenReturn(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/signup/loader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":0,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":"
                                        + "\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"role\":\"Role\"}")));
    }
}

