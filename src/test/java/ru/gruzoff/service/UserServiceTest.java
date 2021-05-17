package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.dto.UserDto;
import ru.gruzoff.entity.Adress;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarType;
import ru.gruzoff.entity.Comments;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Drivers;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.entity.Loaders;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.OrderDetails;
import ru.gruzoff.entity.Role;
import ru.gruzoff.entity.User;
import ru.gruzoff.exception.ConflictException;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.BasicPayload;
import ru.gruzoff.payload.UserDtoPayload;
import ru.gruzoff.repository.CustomerRepository;
import ru.gruzoff.repository.DriversRepository;
import ru.gruzoff.repository.LikesRepository;
import ru.gruzoff.repository.LoadersRepository;
import ru.gruzoff.repository.OrderReposiory;
import ru.gruzoff.repository.RoleRepository;
import ru.gruzoff.repository.UserRepository;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private DriversRepository driversRepository;

    @MockBean
    private LikesRepository likesRepository;

    @MockBean
    private LoadersRepository loadersRepository;

    @MockBean
    private MailService mailService;

    @MockBean
    private OrderReposiory orderReposiory;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testPasswordEncoder() {
        // TODO:

        this.userService.passwordEncoder();
    }

    @Test
    public void testFindByUsername() {
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
        when(this.userRepository.findByUsername(anyString())).thenReturn(ofResult);
        Optional<User> actualFindByUsernameResult = this.userService.findByUsername("janedoe");
        assertSame(ofResult, actualFindByUsernameResult);
        assertTrue(actualFindByUsernameResult.isPresent());
        verify(this.userRepository, times(2)).findByUsername(anyString());
    }

    @Test
    public void testFindByUsername2() {
        Optional<User> emptyResult = Optional.<User>empty();
        when(this.userRepository.findByUsername(anyString())).thenReturn(emptyResult);
        Optional<User> actualFindByUsernameResult = this.userService.findByUsername("janedoe");
        assertSame(emptyResult, actualFindByUsernameResult);
        assertFalse(actualFindByUsernameResult.isPresent());
        verify(this.userRepository, times(2)).findByUsername(anyString());
    }

    @Test
    public void testFindUserByUsername() {
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
        when(this.userRepository.findByUsername(anyString())).thenReturn(ofResult);
        assertSame(user, this.userService.findUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername(anyString());
    }

    @Test
    public void testFindUserByUsername2() {
        when(this.userRepository.findByUsername(anyString())).thenReturn(Optional.<User>empty());
        assertThrows(UserNotFoundExeption.class, () -> this.userService.findUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername(anyString());
    }

    @Test
    public void testFindUserById() {
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
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, this.userService.findUserById(123L));
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testFindUserById2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.<User>empty());
        assertThrows(UserNotFoundExeption.class, () -> this.userService.findUserById(123L));
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testFindById() {
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
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<User> actualFindByIdResult = this.userService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.userRepository, times(2)).findById((Long) any());
    }

    @Test
    public void testFindById2() {
        Optional<User> emptyResult = Optional.<User>empty();
        when(this.userRepository.findById((Long) any())).thenReturn(emptyResult);
        Optional<User> actualFindByIdResult = this.userService.findById(123L);
        assertSame(emptyResult, actualFindByIdResult);
        assertFalse(actualFindByIdResult.isPresent());
        verify(this.userRepository, times(2)).findById((Long) any());
    }

    @Test
    public void testActivateUser() {
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

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByActivationCode(anyString())).thenReturn(ofResult);
        this.userService.activateUser("Encoded User Activation Code");
        verify(this.userRepository).findByActivationCode(anyString());
        verify(this.userRepository).save((User) any());
    }

    @Test
    public void testActivateUser2() {
        when(this.userRepository.save((User) any())).thenThrow(new ConflictException("An error occurred"));
        when(this.userRepository.findByActivationCode(anyString())).thenReturn(Optional.<User>empty());
        assertThrows(NotFoundException.class, () -> this.userService.activateUser("Encoded User Activation Code"));
        verify(this.userRepository).findByActivationCode(anyString());
    }

    @Test
    public void testCreateNewUserAndFillBasicFields() {
        User actualCreateNewUserAndFillBasicFieldsResult = this.userService
                .createNewUserAndFillBasicFields(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                        "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("janedoe", actualCreateNewUserAndFillBasicFieldsResult.getUsername());
        assertEquals("Second Name", actualCreateNewUserAndFillBasicFieldsResult.getSecondName());
        assertEquals("4105551212", actualCreateNewUserAndFillBasicFieldsResult.getPhoneNumber());
        assertEquals("Doe", actualCreateNewUserAndFillBasicFieldsResult.getLastName());
        assertEquals("Jane", actualCreateNewUserAndFillBasicFieldsResult.getFirstName());
        assertEquals("jane.doe@example.org", actualCreateNewUserAndFillBasicFieldsResult.getEmail());
    }

    @Test
    public void testCreateNewUserAndFillBasicFields2() {
        BasicPayload basicPayload = mock(BasicPayload.class);
        when(basicPayload.getSecondName()).thenReturn("foo");
        when(basicPayload.getPhoneNumber()).thenReturn("foo");
        when(basicPayload.getLastName()).thenReturn("foo");
        when(basicPayload.getFirstName()).thenReturn("foo");
        when(basicPayload.getEmail()).thenReturn("foo");
        when(basicPayload.getUsername()).thenReturn("foo");
        User actualCreateNewUserAndFillBasicFieldsResult = this.userService.createNewUserAndFillBasicFields(basicPayload);
        assertEquals("foo", actualCreateNewUserAndFillBasicFieldsResult.getUsername());
        assertEquals("foo", actualCreateNewUserAndFillBasicFieldsResult.getSecondName());
        assertEquals("foo", actualCreateNewUserAndFillBasicFieldsResult.getPhoneNumber());
        assertEquals("foo", actualCreateNewUserAndFillBasicFieldsResult.getLastName());
        assertEquals("foo", actualCreateNewUserAndFillBasicFieldsResult.getFirstName());
        assertEquals("foo", actualCreateNewUserAndFillBasicFieldsResult.getEmail());
        verify(basicPayload).getUsername();
        verify(basicPayload).getFirstName();
        verify(basicPayload).getLastName();
        verify(basicPayload).getPhoneNumber();
        verify(basicPayload).getEmail();
        verify(basicPayload).getSecondName();
    }

    @Test
    public void testFindByEmail() {
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
        when(this.userRepository.findByEmail(anyString())).thenReturn(ofResult);
        Optional<User> actualFindByEmailResult = this.userService.findByEmail("jane.doe@example.org");
        assertSame(ofResult, actualFindByEmailResult);
        assertTrue(actualFindByEmailResult.isPresent());
        verify(this.userRepository, times(2)).findByEmail(anyString());
    }

    @Test
    public void testFindByEmail2() {
        Optional<User> emptyResult = Optional.<User>empty();
        when(this.userRepository.findByEmail(anyString())).thenReturn(emptyResult);
        Optional<User> actualFindByEmailResult = this.userService.findByEmail("jane.doe@example.org");
        assertSame(emptyResult, actualFindByEmailResult);
        assertFalse(actualFindByEmailResult.isPresent());
        verify(this.userRepository, times(2)).findByEmail(anyString());
    }

    @Test
    public void testRegisterNewCustomer() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.mailService).send(anyString(), anyString(), anyString());
        when(this.mailService.completeRegistrationEmail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn("foo");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

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
        user.setRole(role1);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user);
        when(this.customerRepository.save((Customers) any())).thenReturn(customers);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role2);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        when(this.userRepository.save((User) any())).thenReturn(user1);
        UserDto actualRegisterNewCustomerResult = this.userService
                .registerNewCustomer(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                        "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("jane.doe@example.org", actualRegisterNewCustomerResult.getEmail());
        assertEquals("janedoe", actualRegisterNewCustomerResult.getUsername());
        assertEquals("Second Name", actualRegisterNewCustomerResult.getSecondName());
        assertEquals("Name", actualRegisterNewCustomerResult.getRole());
        assertEquals("4105551212", actualRegisterNewCustomerResult.getPhoneNumber());
        assertEquals("Doe", actualRegisterNewCustomerResult.getLastName());
        assertEquals(0L, actualRegisterNewCustomerResult.getId());
        assertEquals("Jane", actualRegisterNewCustomerResult.getFirstName());
        verify(this.customerRepository).save((Customers) any());
        verify(this.mailService).send(anyString(), anyString(), anyString());
        verify(this.mailService).completeRegistrationEmail(anyString(), anyString(), anyString(), anyString());
        verify(this.roleRepository).findById((Long) any());
        verify(this.userRepository).save((User) any());
    }

//    @Test
//    public void testRegisterNewCustomer2() {
//        when(this.roleRepository.findById((Long) any())).thenReturn(Optional.<Role>empty());
//        doNothing().when(this.mailService).send(anyString(), anyString(), anyString());
//        when(this.mailService.completeRegistrationEmail(anyString(), anyString(), anyString(), anyString()))
//                .thenReturn("foo");
//        when(this.customerRepository.save((ru.gruzoff.entity.Customers) any()))
//                .thenThrow(new ConflictException("An error occurred"));
//
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("Name");
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
//        when(this.userRepository.save((User) any())).thenReturn(user);
//        this.userService.registerNewCustomer(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
//                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
//        verify(this.roleRepository).findById((Long) any());
//    }

    @Test
    public void testRegisterNewDriver() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.mailService).send(anyString(), anyString(), anyString());
        when(this.mailService.completeRegistrationEmail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn("foo");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

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
        user.setRole(role1);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());
        when(this.driversRepository.save((Drivers) any())).thenReturn(drivers);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role2);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        when(this.userRepository.save((User) any())).thenReturn(user1);
        UserDto actualRegisterNewDriverResult = this.userService.registerNewDriver(new UserDtoPayload("Jane", "Second Name",
                "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("jane.doe@example.org", actualRegisterNewDriverResult.getEmail());
        assertEquals("janedoe", actualRegisterNewDriverResult.getUsername());
        assertEquals("Second Name", actualRegisterNewDriverResult.getSecondName());
        assertEquals("Name", actualRegisterNewDriverResult.getRole());
        assertEquals("4105551212", actualRegisterNewDriverResult.getPhoneNumber());
        assertEquals("Doe", actualRegisterNewDriverResult.getLastName());
        assertEquals(0L, actualRegisterNewDriverResult.getId());
        assertEquals("Jane", actualRegisterNewDriverResult.getFirstName());
        verify(this.driversRepository).save((Drivers) any());
        verify(this.mailService).send(anyString(), anyString(), anyString());
        verify(this.mailService).completeRegistrationEmail(anyString(), anyString(), anyString(), anyString());
        verify(this.roleRepository).findById((Long) any());
        verify(this.userRepository).save((User) any());
    }

//    @Test
//    public void testRegisterNewDriver2() {
//        when(this.roleRepository.findById((Long) any())).thenReturn(Optional.<Role>empty());
//        doNothing().when(this.mailService).send(anyString(), anyString(), anyString());
//        when(this.mailService.completeRegistrationEmail(anyString(), anyString(), anyString(), anyString()))
//                .thenReturn("foo");
//        when(this.driversRepository.save((ru.gruzoff.entity.Drivers) any()))
//                .thenThrow(new ConflictException("An error occurred"));
//
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("Name");
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
//        when(this.userRepository.save((User) any())).thenReturn(user);
//        this.userService.registerNewDriver(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
//                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
//        verify(this.roleRepository).findById((Long) any());
//    }

    @Test
    public void testRegisterNewLoader() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.mailService).send(anyString(), anyString(), anyString());
        when(this.mailService.completeRegistrationEmail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn("foo");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

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
        user.setRole(role1);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());

        Loaders loaders = new Loaders();
        loaders.setId(123L);
        loaders.setUser(user);
        when(this.loadersRepository.save((Loaders) any())).thenReturn(loaders);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role2);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        when(this.userRepository.save((User) any())).thenReturn(user1);
        UserDto actualRegisterNewLoaderResult = this.userService.registerNewLoader(new UserDtoPayload("Jane", "Second Name",
                "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("jane.doe@example.org", actualRegisterNewLoaderResult.getEmail());
        assertEquals("janedoe", actualRegisterNewLoaderResult.getUsername());
        assertEquals("Second Name", actualRegisterNewLoaderResult.getSecondName());
        assertEquals("Name", actualRegisterNewLoaderResult.getRole());
        assertEquals("4105551212", actualRegisterNewLoaderResult.getPhoneNumber());
        assertEquals("Doe", actualRegisterNewLoaderResult.getLastName());
        assertEquals(0L, actualRegisterNewLoaderResult.getId());
        assertEquals("Jane", actualRegisterNewLoaderResult.getFirstName());
        verify(this.loadersRepository).save((Loaders) any());
        verify(this.mailService).send(anyString(), anyString(), anyString());
        verify(this.mailService).completeRegistrationEmail(anyString(), anyString(), anyString(), anyString());
        verify(this.roleRepository).findById((Long) any());
        verify(this.userRepository).save((User) any());
    }

//    @Test
//    public void testRegisterNewLoader2() {
//        when(this.roleRepository.findById((Long) any())).thenReturn(Optional.<Role>empty());
//        doNothing().when(this.mailService).send(anyString(), anyString(), anyString());
//        when(this.mailService.completeRegistrationEmail(anyString(), anyString(), anyString(), anyString()))
//                .thenReturn("foo");
//        when(this.loadersRepository.save((ru.gruzoff.entity.Loaders) any()))
//                .thenThrow(new ConflictException("An error occurred"));
//
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("Name");
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
//        when(this.userRepository.save((User) any())).thenReturn(user);
//        this.userService.registerNewLoader(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
//                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
//        verify(this.roleRepository).findById((Long) any());
//    }

    @Test
    public void testConvertUserToUserDto() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
        user.setRole(role);
        UserDto actualConvertUserToUserDtoResult = this.userService.convertUserToUserDto(user);
        assertNull(actualConvertUserToUserDtoResult.getEmail());
        assertEquals("janedoe", actualConvertUserToUserDtoResult.getUsername());
        assertNull(actualConvertUserToUserDtoResult.getSecondName());
        assertEquals("Name", actualConvertUserToUserDtoResult.getRole());
        assertNull(actualConvertUserToUserDtoResult.getPhoneNumber());
        assertNull(actualConvertUserToUserDtoResult.getLastName());
        assertEquals(123L, actualConvertUserToUserDtoResult.getId());
        assertNull(actualConvertUserToUserDtoResult.getFirstName());
    }

    @Test
    public void testGetUsersOrderByOrderId() {
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

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user);
        Optional<Customers> ofResult = Optional.<Customers>of(customers);
        when(this.customerRepository.findByUser((User) any())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user1);
        drivers.setCars(new ArrayList<Car>());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment("Comment");
        orderDetails.setLoadersCapacity(1);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType1);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName("Name");

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(new ArrayList<Likes>());
        user2.setActivationCode("Activation Code");
        user2.setPuttedComments(new ArrayList<Comments>());
        user2.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setId(123L);
        user2.setOrders(new ArrayList<Order>());
        user2.setRole(role2);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setUsername("janedoe");
        user2.setRecievedComments(new ArrayList<Comments>());
        user2.setSecondName("Second Name");
        user2.setPuttedLikes(new ArrayList<Likes>());

        Customers customers1 = new Customers();
        customers1.setId(123L);
        customers1.setUser(user2);

        Order order = new Order();
        order.setExtraCustomers(new ArrayList<Customers>());
        order.setSended(true);
        order.setDriverId(drivers);
        order.setStatus("Status");
        order.setPrice(10.0f);
        order.setOrderDetails(orderDetails);
        order.setId(123L);
        order.setCarId(car);
        order.setCustomerId(customers1);
        order.setLoaders(new ArrayList<Loaders>());
        Optional<Order> ofResult1 = Optional.<Order>of(order);
        when(this.orderReposiory.findByIdAndCustomerId(anyLong(), (Customers) any())).thenReturn(ofResult1);
        assertSame(order, this.userService.getUsersOrderByOrderId(new User(123L, "janedoe"), 1L));
        verify(this.customerRepository).findByUser((User) any());
        verify(this.orderReposiory).findByIdAndCustomerId(anyLong(), (Customers) any());
    }
}

