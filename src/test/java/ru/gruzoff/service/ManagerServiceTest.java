package ru.gruzoff.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.Order;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.repository.OrderReposiory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ContextConfiguration(classes = {ManagerService.class, ClassToDtoService.class, MailService.class})
@ExtendWith(SpringExtension.class)
public class ManagerServiceTest {
    @MockBean
    OrderReposiory orderReposiory;

    @Autowired
    ManagerService managerService;

    @MockBean
    ClassToDtoService classToDtoService;

    @MockBean
    MailService mailService;

    @Test
    public void testGetOrdersToAccept_empty(){
        ArrayList<Optional<Order>> list = new ArrayList<Optional<Order>>();
        when(this.orderReposiory.findAllByStatus("WAIT_APPROVE")).thenReturn(list);

        assertTrue(this.managerService.getOrdersToAccept().isEmpty());
    }

    @Test
    public void testGetOrdersToAccept_list(){
        ArrayList<Optional<Order>> list = new ArrayList<Optional<Order>>();
        Order order = new Order();
        order.setStatus("WAIT_APPROVE");
        list.add(Optional.of(order));

        when(this.orderReposiory.findAllByStatus("WAIT_APPROVE")).thenReturn(list);

        ArrayList<OrderDto> dtoList = new ArrayList<OrderDto>();
        dtoList.add(classToDtoService.convertOrderToOrderDto(list.get(0).get()));

        assertEquals(dtoList, this.managerService.getOrdersToAccept());
    }

    @Test
    public void testGetOrdersToAccept_listSize(){
        ArrayList<Optional<Order>> list = new ArrayList<Optional<Order>>();
        Order order1 = new Order();
        order1.setStatus("WAIT_APPROVE");
        Order order2 = new Order();
        order2.setStatus("WAIT_APPROVE");
        list.add(Optional.of(order1));
        list.add(Optional.of(order2));

        when(this.orderReposiory.findAllByStatus("WAIT_APPROVE")).thenReturn(list);

        assertEquals(2, this.managerService.getOrdersToAccept().size());
    }


    @Test
    public void testAcceptById_notFound(){
        when(this.orderReposiory.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.managerService.acceptById(123L, 1));
    }

    @Test
    public void testAcceptById_notValidSt(){    //не происходит обработка
        assertThrows(Exception.class, () -> this.managerService.acceptById(123L, 0));
    }

    @Test
    public void testAcceptById_correct(){
        assertThrows(Exception.class, () -> this.managerService.acceptById(123L, 0));
    }

}
