package ru.gruzoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.User;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.CreateOrderDtoPayload;
import ru.gruzoff.service.OrderService;
import ru.gruzoff.service.UserService;

@RestController
@RequestMapping(value = "/v1/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }

    @PostMapping("/create_order")
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderDtoPayload createOrderDtoPayload) {
        User currUser = getAuthentificatedUser();
        if (!currUser.getRole().getName().equals("ROLE_ADMIN")) {
            createOrderDtoPayload.setCustomerId(currUser.getId());
        }

        return ResponseEntity.ok(orderService.createNewOrder(createOrderDtoPayload));
    }
}
