package ru.gruzoff.security.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.entity.Comments;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.Role;
import ru.gruzoff.entity.User;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {JwtUserDetailsService.class, UserService.class})
@ExtendWith(SpringExtension.class)
public class JwtUserDetailsServiceTest {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private UserService userService;

    @Test
    public void testLoadUserByUsername() throws UsernameNotFoundException {
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
        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.jwtUserDetailsService.loadUserByUsername("janedoe");
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        verify(this.userService).findByUsername(anyString());
    }

//    @Test
//    public void testLoadUserByUsername2() throws UsernameNotFoundException {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("");
//
//        User user = new User();
//        user.setLastName("Doe");
//        user.setEmail("jane.doe@example.org");
//        user.setPassword("iloveyou");
//        user.setRecievedLikes(new ArrayList<Likes>());
//        user.setActivationCode("Activation Code");
//        user.setPuttedComments(new ArrayList<Comments>());
//        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
//        user.setId(123L);
//        user.setOrders(new ArrayList<Order>());
//        user.setRole(role);
//        user.setPhoneNumber("4105551212");
//        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
//        user.setUserProfileImageUrl("https://example.org/example");
//        user.setFirstName("Jane");
//        user.setUsername("janedoe");
//        user.setRecievedComments(new ArrayList<Comments>());
//        user.setSecondName("Second Name");
//        user.setPuttedLikes(new ArrayList<Likes>());
//        Optional<User> ofResult = Optional.<User>of(user);
//        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);
//        this.jwtUserDetailsService.loadUserByUsername("janedoe");
//        verify(this.userService).findByUsername(anyString());
//    }

    @Test
    public void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(this.userService.findByUsername(anyString())).thenReturn(Optional.<User>empty());
        assertThrows(UsernameNotFoundException.class, () -> this.jwtUserDetailsService.loadUserByUsername("janedoe"));
        verify(this.userService).findByUsername(anyString());
    }
}

