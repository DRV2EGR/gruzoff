package ru.gruzoff.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.Order;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.repository.OrderReposiory;

@Service
@Slf4j
public class ManagerService {
    @Autowired
    OrderReposiory orderReposiory;

    @Autowired
    ClassToDtoService classToDtoService;

    @Autowired
    MailService mailService;

    Logger logger = LoggerFactory.getLogger("orderLogger");

    public List<OrderDto> getOrdersToAccept() {
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (Optional<Order> order : orderReposiory.findAllByStatus("WAIT_APPROVE")) {
            orderDtoList.add(
                    classToDtoService.convertOrderToOrderDto(order.get())
            );
        }

        return orderDtoList;
    }

    public void acceptById(long orderId, int st) {
        if (st == 1) { //Accept
            Order order = orderReposiory.findById(orderId).orElseThrow(
                    () -> new NotFoundException("Order not found")
            );
            order.setStatus("IN_WORK");

            logger.info("Order " + order.getId() + " approved at " + LocalDateTime.now());
            mailService.send(order.getCustomerId().getUser().getEmail(), "Заказ подтвержден.",
                    mailService.creationOrderNotify(order.getCustomerId().getUser(), order));
            orderReposiory.save(order);
        } else if (st == 2) { // UserNotAccept
            Order order = orderReposiory.findById(orderId).orElseThrow(
                    () -> new NotFoundException("Order not found")
            );
            order.setStatus("DELETED");
            orderReposiory.save(order);
        }
    }
}
