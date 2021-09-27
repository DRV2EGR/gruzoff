package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.dto.OrderDetailsDto;
import ru.gruzoff.dto.OrderDto;
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
import ru.gruzoff.payload.CreateOrderDtoPayload;
import ru.gruzoff.payload.OrderDetailsDtoPayload;
import ru.gruzoff.payload.UserDtoPayload;
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
    public void testGetOrderById_correct(){
        Order order1 = new Order();
        order1.setId(3);
        OrderDto orderDto = classToDtoService.convertOrderToOrderDto(order1);

        when(this.orderReposiory.findById(3L)).thenReturn(Optional.of(order1));

        assertEquals(orderDto, this.orderService.getOrderById(3));
    }

    @Test
    public void testGetOrderById_notFound(){
        assertThrows(NotFoundException.class, () -> this.orderService.getOrderById(72));
    }

    @Test
    public void testGetOrderById_id0(){
        assertThrows(Exception.class, () -> this.orderService.getOrderById(0L));
    }

    @Test
    public void testGetOrderById_idMin(){
        assertThrows(Exception.class, () -> this.orderService.getOrderById(-5L));
    }

//    @Test
//    public void testCreateNewOrder_correct() throws Exception {
//
//        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
//        createOrderDtoPayload.setCustomerId(1L);
//        createOrderDtoPayload.setCar_type(1L);
//        createOrderDtoPayload.setNumOfLoaders(1);
//
//        UserDtoPayload userDtoPayload = new UserDtoPayload("", "", "", "", "", "", "", "");
//        List userList =  List.of(userDtoPayload);
//
//        createOrderDtoPayload.setExtraCustomers(userList);
//
//        Adress adress = new Adress(); adress.setLatitude(13); adress.setLongitude(222); adress.setCountry("c"); adress.setStreet("s");
//        adress.setTown("t"); adress.setHouseNomber("56");
//
//
//        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
//        orderDetailsDtoPayload.setAdressFrom(adress);
//        orderDetailsDtoPayload.setAdressTo(adress);
//        orderDetailsDtoPayload.setLoadersCapacity(2);
//        orderDetailsDtoPayload.setTimeOnOrder(3);
//        orderDetailsDtoPayload.setComment("");
//        orderDetailsDtoPayload.setDateTime(new Date());
//
//        createOrderDtoPayload.setOrderDetails(orderDetailsDtoPayload);
//
//
//
//        OrderDto orderDto = new OrderDto(); orderDto.setOrderDetails(new OrderDetailsDto());
//
//
//        CarType carType = new CarType(); carType.setPricePerHour(120); carType.setDescription(""); carType.setId(1L);
//        User user = new User("f", "s", "l", "e", "p");
//        Customers customer = new Customers();
//
//        when(this.carTypeRepository.findById((Long) any())).thenReturn(Optional.of(carType));
//        when(this.userService.findById((Long) any())).thenReturn(Optional.of(user));
//        when(this.customerRepository.findByUser((User) any())).thenReturn(Optional.of(customer));
//        when(this.roleRepository.findById((Long) any())).thenReturn(Optional.of(new Role()));
//
//        System.out.println(orderDto);
//        System.out.println("\n\n");
//        System.out.println(this.orderService.createNewOrder(createOrderDtoPayload).toString());
//
//        assertEquals(orderDto, this.orderService.createNewOrder(createOrderDtoPayload));
//    }

    @Test
    public void testCreateNewOrder_exception(){
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        OrderDto orderDto = new OrderDto(); orderDto.setOrderDetails(new OrderDetailsDto());

        assertThrows(Exception.class, () -> this.orderService.createNewOrder(createOrderDtoPayload));
    }

    @Test
    public void testFindOrdersOnDate(){
        ArrayList list = new ArrayList();
        Order order = new Order();
        list.add(order);

        User user = new User();

        when(this.driversRepository.findByUser(user).isPresent()).thenReturn(true);
        when(this.driversRepository.findByUser(user).get()).thenReturn();



        Date date1 = new Date(11);

        when(user.getOrders());
    }
}

