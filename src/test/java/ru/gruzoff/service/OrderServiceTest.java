package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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

    @Test
    public void testCreateNewOrder_exception(){
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        OrderDto orderDto = new OrderDto(); orderDto.setOrderDetails(new OrderDetailsDto());

        assertThrows(Exception.class, () -> this.orderService.createNewOrder(createOrderDtoPayload));
    }
//    Выполняется путем поиска водителя (driversRepository.findByUser(user).isPresent())
//    Затем поиском заказов по id водителя orderReposiory.findAllByDriverId(), если таковые найдены
//    Затем для грузчика поиск по пользователю (loadersRepository.findByUser(user).isPresent())) и
//    выборка заказов по id грузчика orderReposiory.findAllByLoadersContaining(loader), если таковые найдены
    @Test
    public void testFindOrdersOnDate_notNull(){
        User user = new User();
        Date date = new Date(17);

        OrderDetails orderDetails = new OrderDetails(); orderDetails.setDateTime(date);
        Order order = new Order(); order.setOrderDetails(orderDetails);
        Drivers drivers = new Drivers();
        Loaders loaders = new Loaders();
        ArrayList<Optional<Order>> list = new ArrayList<Optional<Order>>();; list.add(Optional.of(order));

        when(this.driversRepository.findByUser(user)).thenReturn(Optional.of(drivers));
        when(orderReposiory.findAllByDriverId((Drivers) any())).thenReturn(list);

        when(this.loadersRepository.findByUser(user)).thenReturn(Optional.of(loaders));
        when(this.orderReposiory.findAllByLoadersContaining((Loaders) any())).thenReturn(list);

        assertNotNull(orderService.findOrdersOnDate(user, date));
        verify(this.driversRepository, times(2)).findByUser((User) any());
        verify(this.orderReposiory).findAllByDriverId((Drivers) any());
        verify(this.orderReposiory).findAllByLoadersContaining((Loaders) any());
    }

    @Test
    public void testFindOrdersOnDate_size_correct(){
        User user = new User();
        Date date = new Date(17);

        OrderDetails orderDetails = new OrderDetails(); orderDetails.setDateTime(date);
        Order order = new Order(); order.setOrderDetails(orderDetails);
        Drivers drivers = new Drivers();
        Loaders loaders = new Loaders();
        ArrayList<Optional<Order>> list1 = new ArrayList<Optional<Order>>();; list1.add(Optional.of(order));
        ArrayList<Optional<Order>> list2 = new ArrayList<Optional<Order>>();; list2.add(Optional.of(order));

        when(this.driversRepository.findByUser(user)).thenReturn(Optional.of(drivers));
        when(orderReposiory.findAllByDriverId((Drivers) any())).thenReturn(list1);

        when(this.loadersRepository.findByUser(user)).thenReturn(Optional.of(loaders));
        when(this.orderReposiory.findAllByLoadersContaining((Loaders) any())).thenReturn(list2);

        assertEquals(1, this.orderService.findOrdersOnDate(user, date).size());
        assertEquals(date, this.orderService.findOrdersOnDate(user, date).get(0).getOrderDetails().getDateTime());
    }

    @Test
    public void testFindOrdersOnDate_driverOnly(){
        User user = new User();
        Date date = new Date(17);

        OrderDetails orderDetails = new OrderDetails(); orderDetails.setDateTime(date);
        Order order = new Order(); order.setOrderDetails(orderDetails);
        Drivers drivers = new Drivers();
        Loaders loaders = new Loaders();
        ArrayList<Optional<Order>> list1 = new ArrayList<Optional<Order>>();; list1.add(Optional.of(order));

        when(this.driversRepository.findByUser(user)).thenReturn(Optional.of(drivers));
        when(orderReposiory.findAllByDriverId((Drivers) any())).thenReturn(list1);

        when(this.loadersRepository.findByUser(user)).thenReturn(Optional.empty());
        when(this.orderReposiory.findAllByLoadersContaining((Loaders) any())).thenReturn(Arrays.asList());

        assertEquals(1, this.orderService.findOrdersOnDate(user, date).size());
        //assertEquals(date, this.orderService.findOrdersOnDate(user, date).get(0).getOrderDetails().getDateTime());
    }
}

