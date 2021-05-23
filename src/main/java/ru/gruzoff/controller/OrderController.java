package ru.gruzoff.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.User;
import ru.gruzoff.exception.BadRequestException;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.CreateOrderDtoPayload;
import ru.gruzoff.payload.DateFilterDtoPayload;
import ru.gruzoff.service.ClassToDtoService;
import ru.gruzoff.service.OrderService;
import ru.gruzoff.service.UserService;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping(value = "/v1/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Order service.
     */
    @Autowired
    OrderService orderService;

    /**
     * The Class to dto service.
     */
    @Autowired
    ClassToDtoService classToDtoService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }

    /**
     * Create order response entity.
     *
     * @param createOrderDtoPayload the create order dto payload
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/create_order")
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderDtoPayload createOrderDtoPayload) throws Exception {
        User currUser = getAuthentificatedUser();
        if (!currUser.getRole().getName().equals("ROLE_ADMIN")) {
            createOrderDtoPayload.setCustomerId(currUser.getId());
        }

        if (!currUser.getRole().getName().equals("ROLE_CUSTOMER")) {
            throw new BadRequestException("User is not customer");
        }
        return ResponseEntity.ok(orderService.createNewOrder(createOrderDtoPayload));
    }

    /**
     * Gets all user orders.
     *
     * @return the all user orders
     */
    @GetMapping("/all")
    public  ResponseEntity<List<OrderDto>> getAllUserOrders() {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : getAuthentificatedUser().getOrders())
            orderDtoList.add(classToDtoService.convertOrderToOrderDto(order));

        return ResponseEntity.ok(orderDtoList);
    }

    /**
     * Gets user orders between dates.
     *
     * @param dateFilterDtoPayload the date filter dto payload
     * @return the user orders between dates
     */
    @PostMapping("/filter_dates")
    public  ResponseEntity<List<OrderDto>> getUserOrdersBetweenDates(@RequestBody DateFilterDtoPayload dateFilterDtoPayload) {
        return ResponseEntity.ok(orderService.findOrdersBetweenDates(
                getAuthentificatedUser(),
                dateFilterDtoPayload.getDate1(),
                dateFilterDtoPayload.getDate2()
        ));
    }

    /**
     * Gets all user orders admin.
     *
     * @param id the id
     * @return the all user orders admin
     */
    @GetMapping("/admin/orders")
    public  ResponseEntity<List<OrderDto>> getAllUserOrdersAdmin(@RequestParam long id) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : userService.findUserById(id).getOrders())
            orderDtoList.add(classToDtoService.convertOrderToOrderDto(order));

        return ResponseEntity.ok(orderDtoList);
    }

    /**
     * Gets user orders between dates by user id admin.
     *
     * @param id                   the id
     * @param date1                the date 1
     * @param dateFilterDtoPayload the date filter dto payload
     * @return the user orders between dates by user id admin
     */
    @PostMapping("/admin/orders_filterred_dates")
    public  ResponseEntity<List<OrderDto>> getUserOrdersBetweenDatesByUserIdAdmin(
            @RequestParam long id,
            @RequestParam Date date1,
            @RequestBody DateFilterDtoPayload dateFilterDtoPayload )
    {
        return ResponseEntity.ok(orderService.findOrdersBetweenDates(
                userService.findUserById(id),
                dateFilterDtoPayload.getDate1(),
                dateFilterDtoPayload.getDate2()
        ));
    }

    /**
     * Gets order by id.
     *
     * @param orderId the order id
     * @return the order by id
     */
    @GetMapping("/get_order_by_id")
    public ResponseEntity<OrderDto> getOrderById(@RequestParam long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
