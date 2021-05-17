package ru.gruzoff.security.jwt;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gruzoff.entity.Comments;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.RefreshToken;
import ru.gruzoff.entity.Role;
import ru.gruzoff.entity.User;
import ru.gruzoff.repository.RefreshTokenRepository;
import ru.gruzoff.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = {JwtTokenProvider.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
public class JwtTokenProviderTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private RefreshTokenRepository refreshTokenRepository;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateAccessToken() {
        Role role = new Role();
        role.setId(123L);
        role.setName("role");

        User user = new User(1L, "janedoe");
        user.setRole(role);
        assertNotNull(this.jwtTokenProvider.createAccessToken(user));
    }

    @Test
    public void testCreateAccessToken2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("role");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("role");
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
        user.setSecondName("role");
        user.setPuttedLikes(new ArrayList<Likes>());
        assertNotNull(this.jwtTokenProvider.createAccessToken(user));
    }

    @Test
    public void testCreateAccessToken3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getRole()).thenReturn(role);
        when(user.getUsername()).thenReturn("foo");
        assertNotNull(this.jwtTokenProvider.createAccessToken(user));
    }

    @Test
    public void testCreateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken("ABC123");
        refreshToken.setUserId(123L);
        when(this.refreshTokenRepository.save((RefreshToken) any())).thenReturn(refreshToken);
        assertNotNull(this.jwtTokenProvider.createRefreshToken(-1L));
    }

    @Test
    public void testResolveAccessToken() {
        assertNull(this.jwtTokenProvider.resolveAccessToken(new MockHttpServletRequest()));
        assertNull(this.jwtTokenProvider
                .resolveAccessToken(new MockHttpServletRequest("https://example.org/example", "https://example.org/example")));
    }

    @Test
    public void testValidateAccessToken() {
        assertFalse(this.jwtTokenProvider.validateAccessToken("ABC123"));
        assertFalse(this.jwtTokenProvider.validateAccessToken("Token"));
    }

    @Test
    public void testValidateRefreshToken() {
        assertFalse(this.jwtTokenProvider.validateRefreshToken("ABC123"));
        assertFalse(this.jwtTokenProvider.validateRefreshToken("Token"));
    }

//    @Test
//    public void testGetAuthentication() {
//        // TODO:
//
//        this.jwtTokenProvider.getAuthentication("ABC123");
//    }

//    @Test
//    public void testGetAuthentication2() {
//        assertNull(this.jwtTokenProvider.getAuthentication("Token"));
//    }

//    @Test
//    public void testRefreshPairOfTokens() {
//        assertNull(this.jwtTokenProvider.refreshPairOfTokens("Refresh Token String"));
//    }
}

