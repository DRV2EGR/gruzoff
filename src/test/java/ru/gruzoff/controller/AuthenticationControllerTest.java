package ru.gruzoff.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.gruzoff.dto.AuthenticationRequestDto;
import ru.gruzoff.dto.JwtAuthDto;
import ru.gruzoff.entity.Comments;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.Role;
import ru.gruzoff.entity.User;
import ru.gruzoff.security.jwt.JwtTokenProvider;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {AuthenticationController.class})
@ExtendWith(SpringExtension.class)
public class AuthenticationControllerTest {
    @Autowired
    private AuthenticationController authenticationController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private UserService userService;

    @Test
    public void testActivateUser() throws Exception {
        doNothing().when(this.userService).activateUser(anyString());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/auth/activate/{activationCode}",
                "Activation Code");
        MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"OK\"")));
    }

    @Test
    public void testLogin() throws Exception {
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
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByEmail(anyString())).thenReturn(ofResult);
        when(this.jwtTokenProvider.createRefreshToken(anyLong())).thenReturn("foo");
        when(this.jwtTokenProvider.createAccessToken((User) any())).thenReturn("foo");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        authenticationRequestDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers
                                .containsString("{\"username\":\"janedoe\",\"accessToken\":\"foo\",\"refreshToken\":\"foo\"}")));
    }

    @Test
    public void testLogin2() throws Exception {
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
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByEmail(anyString())).thenReturn(ofResult);
        when(this.jwtTokenProvider.createRefreshToken(anyLong())).thenThrow(new IllegalArgumentException("foo"));
        when(this.jwtTokenProvider.createAccessToken((User) any())).thenReturn("foo");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        authenticationRequestDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void testLogin3() throws Exception {
        when(this.userService.findByEmail(anyString())).thenReturn(Optional.<User>empty());
        when(this.jwtTokenProvider.createRefreshToken(anyLong())).thenReturn("foo");
        when(this.jwtTokenProvider.createAccessToken((User) any())).thenReturn("foo");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        authenticationRequestDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void testRefresh() throws Exception {
        when(this.jwtTokenProvider.refreshPairOfTokens(anyString())).thenReturn(new JwtAuthDto());

        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        jwtAuthDto.setAccessToken("ABC123");
        jwtAuthDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(jwtAuthDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"username\":null,\"accessToken\":null,\"refreshToken\":null}")));
    }
}

