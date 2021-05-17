package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.entity.Order;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.repository.OrderReposiory;

@ContextConfiguration(classes = {ManagerService.class, ClassToDtoService.class, MailService.class})
@ExtendWith(SpringExtension.class)
public class ManagerServiceTest {
    @MockBean
    private ClassToDtoService classToDtoService;

    @MockBean
    private MailService mailService;

    @Autowired
    private ManagerService managerService;

    @MockBean
    private OrderReposiory orderReposiory;

    @Test
    public void testGetOrdersToAccept() {
        when(this.orderReposiory.findAllByStatus(anyString())).thenReturn(new ArrayList<Optional<Order>>());
        assertTrue(this.managerService.getOrdersToAccept().isEmpty());
        verify(this.orderReposiory).findAllByStatus(anyString());
    }

    @Test
    public void testGetOrdersToAccept2() {
        ArrayList<Optional<Order>> optionalList = new ArrayList<Optional<Order>>();
        optionalList.addAll(new ArrayList<Optional<Order>>());
        when(this.orderReposiory.findAllByStatus(anyString())).thenReturn(optionalList);
        assertTrue(this.managerService.getOrdersToAccept().isEmpty());
        verify(this.orderReposiory).findAllByStatus(anyString());
    }

    @Test
    public void testAcceptById() {
        when(this.orderReposiory.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.managerService.acceptById(123L, 1));
        verify(this.orderReposiory).findById((Long) any());
    }

    @Test
    public void testAcceptById2() {
        when(this.orderReposiory.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        this.managerService.acceptById(123L, 0);
        assertTrue(this.managerService.logger instanceof org.apache.logging.slf4j.Log4jLogger);
    }

    @Test
    public void testAcceptById3() {
        when(this.orderReposiory.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.managerService.acceptById(123L, 2));
        verify(this.orderReposiory).findById((Long) any());
    }
}

