package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
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
import ru.gruzoff.repository.AdressRepository;
import ru.gruzoff.repository.CarRepository;
import ru.gruzoff.repository.CarTypeRepository;
import ru.gruzoff.repository.CarValidityRepository;
import ru.gruzoff.repository.CustomerRepository;
import ru.gruzoff.repository.DriversRepository;
import ru.gruzoff.repository.LoadersRepository;
import ru.gruzoff.repository.OrderDetailsReposirory;
import ru.gruzoff.repository.OrderReposiory;
import ru.gruzoff.repository.RoleRepository;
import ru.gruzoff.repository.UserRepository;

@ContextConfiguration(classes = {OrderService.class, ClassToDtoService.class, GeocoderService.class, MailService.class,
        UserService.class})
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {
    @MockBean
    private AdressRepository adressRepository;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private CarTypeRepository carTypeRepository;

    @MockBean
    private CarValidityRepository carValidityRepository;

    @MockBean
    private ClassToDtoService classToDtoService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private DriversRepository driversRepository;

    @MockBean
    private GeocoderService geocoderService;

    @MockBean
    private LoadersRepository loadersRepository;

    @MockBean
    private MailService mailService;

    @MockBean
    private OrderDetailsReposirory orderDetailsReposirory;

    @MockBean
    private OrderReposiory orderReposiory;

    @Autowired
    private OrderService orderService;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @Test
    public void testFindOrdersBetweenDates() {
        User user = new User(123L, "janedoe");
        user.setOrders(new ArrayList<Order>());
        Date d1 = new Date(1L);
        assertTrue(this.orderService.findOrdersBetweenDates(user, d1, new Date(1L)).isEmpty());
    }

    @Test
    public void testFindOrdersBetweenDates2() {
        User user = mock(User.class);
        when(user.getOrders()).thenReturn(new ArrayList<Order>());
        Date d1 = new Date(1L);
        assertTrue(this.orderService.findOrdersBetweenDates(user, d1, new Date(1L)).isEmpty());
        verify(user).getOrders();
    }

    @Test
    public void testFindOrdersBetweenDates3() {
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

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
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
        orderDetails.setLoadersCapacity(0);

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
        car.setHeight(0);

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

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user1);

        Order order = new Order();
        order.setExtraCustomers(new ArrayList<Customers>());
        order.setSended(true);
        order.setDriverId(drivers);
        order.setStatus("Status");
        order.setPrice(10.0f);
        order.setOrderDetails(orderDetails);
        order.setId(123L);
        order.setCarId(car);
        order.setCustomerId(customers);
        order.setLoaders(new ArrayList<Loaders>());

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);
        User user2 = mock(User.class);
        when(user2.getOrders()).thenReturn(orderList);
        Date d1 = new Date(1L);
        assertTrue(this.orderService.findOrdersBetweenDates(user2, d1, new Date(1L)).isEmpty());
        verify(user2).getOrders();
    }

    @Test
    public void testTakeOrderToDriver() {
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

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
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

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user1);

        Order order = new Order();
        order.setExtraCustomers(new ArrayList<Customers>());
        order.setSended(true);
        order.setDriverId(drivers);
        order.setStatus("Status");
        order.setPrice(10.0f);
        order.setOrderDetails(orderDetails);
        order.setId(123L);
        order.setCarId(car);
        order.setCustomerId(customers);
        order.setLoaders(new ArrayList<Loaders>());
        Optional<Order> ofResult = Optional.<Order>of(order);
        when(this.orderReposiory.findById((Long) any())).thenReturn(ofResult);

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

        Drivers drivers1 = new Drivers();
        drivers1.setId(123L);
        drivers1.setUser(user2);
        drivers1.setCars(new ArrayList<Car>());
        Optional<Drivers> ofResult1 = Optional.<Drivers>of(drivers1);
        when(this.driversRepository.findByUser((User) any())).thenReturn(ofResult1);
        assertFalse(this.orderService.takeOrderToDriver(new User(123L, "janedoe"), 123L, 123L));
        verify(this.driversRepository).findByUser((User) any());
        verify(this.orderReposiory).findById((Long) any());
    }

    @Test
    public void testShowReleventOrdersOnDay() {
        when(this.orderReposiory.findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any()))
                .thenReturn(new ArrayList<Optional<Order>>());
        assertTrue(this.orderService.showReleventOrdersOnDay(new Date(1L), 1).isEmpty());
        verify(this.orderReposiory).findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any());
    }

    @Test
    public void testShowReleventOrdersOnDay2() {
        when(this.orderReposiory.findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any()))
                .thenReturn(new ArrayList<Optional<Order>>());
        assertTrue(this.orderService.showReleventOrdersOnDay(new Date(0L), 1).isEmpty());
        verify(this.orderReposiory).findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any());
    }

    @Test
    public void testShowReleventOrdersOnDay3() {
        when(this.orderReposiory.findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any()))
                .thenReturn(new ArrayList<Optional<Order>>());
        assertTrue(this.orderService.showReleventOrdersOnDay(new Date(1L), 0).isEmpty());
    }

    @Test
    public void testShowReleventOrdersOnDay4() {
        when(this.orderReposiory.countByLoaders((Date) any())).thenReturn(new ArrayList<Optional<Long>>());
        when(this.orderReposiory.findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any()))
                .thenReturn(new ArrayList<Optional<Order>>());
        assertTrue(this.orderService.showReleventOrdersOnDay(new Date(1L), 2).isEmpty());
        verify(this.orderReposiory).countByLoaders((Date) any());
    }

    @Test
    public void testShowReleventOrdersOnDay5() {
        ArrayList<Optional<Long>> optionalList = new ArrayList<Optional<Long>>();
        optionalList.add(Optional.<Long>of(42L));
        when(this.orderReposiory.findById((Long) any())).thenThrow(new ConflictException("An error occurred"));
        when(this.orderReposiory.countByLoaders((Date) any())).thenReturn(optionalList);
        when(this.orderReposiory.findAllByDriverIdIsNullAndOrderDetailsDateTime((Date) any()))
                .thenReturn(new ArrayList<Optional<Order>>());
        assertThrows(ConflictException.class, () -> this.orderService.showReleventOrdersOnDay(new Date(1L), 2));
        verify(this.orderReposiory).findById((Long) any());
        verify(this.orderReposiory).countByLoaders((Date) any());
    }

    @Test
    public void testGetAllDriverCars() {
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

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());
        Optional<Drivers> ofResult = Optional.<Drivers>of(drivers);
        when(this.driversRepository.findByUser((User) any())).thenReturn(ofResult);
        assertTrue(this.orderService.getAllDriverCars(new User(123L, "janedoe")).isEmpty());
        verify(this.driversRepository).findByUser((User) any());
    }

    @Test
    public void testGetAllDriverCars2() {
        when(this.driversRepository.findByUser((User) any())).thenReturn(Optional.<Drivers>empty());
        assertThrows(NotFoundException.class, () -> this.orderService.getAllDriverCars(new User(123L, "janedoe")));
        verify(this.driversRepository).findByUser((User) any());
    }
}

