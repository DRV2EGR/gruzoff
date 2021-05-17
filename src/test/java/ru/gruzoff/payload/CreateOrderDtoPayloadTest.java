package ru.gruzoff.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import ru.gruzoff.entity.Adress;

public class CreateOrderDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CreateOrderDtoPayload()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        assertTrue(createOrderDtoPayload.canEqual(new CreateOrderDtoPayload()));
    }

    @Test
    public void testConstructor() {
        CreateOrderDtoPayload actualCreateOrderDtoPayload = new CreateOrderDtoPayload();
        actualCreateOrderDtoPayload.setCar_type(1L);
        actualCreateOrderDtoPayload.setCustomerId(123L);
        ArrayList<UserDtoPayload> userDtoPayloadList = new ArrayList<UserDtoPayload>();
        actualCreateOrderDtoPayload.setExtraCustomers(userDtoPayloadList);
        actualCreateOrderDtoPayload.setNumOfLoaders(10);
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        actualCreateOrderDtoPayload.setOrderDetails(orderDetailsDtoPayload);
        assertEquals(1L, actualCreateOrderDtoPayload.getCar_type());
        assertEquals(123L, actualCreateOrderDtoPayload.getCustomerId());
        assertSame(userDtoPayloadList, actualCreateOrderDtoPayload.getExtraCustomers());
        assertEquals(10, actualCreateOrderDtoPayload.getNumOfLoaders());
        assertSame(orderDetailsDtoPayload, actualCreateOrderDtoPayload.getOrderDetails());
        assertEquals(
                "CreateOrderDtoPayload(customerId=123, car_type=1, numOfLoaders=10, orderDetails=OrderDetailsDtoPayload"
                        + "(adressFrom=null, adressTo=null, dateTime=null, timeOnOrder=0.0, loadersCapacity=0, comment=null),"
                        + " extraCustomers=[])",
                actualCreateOrderDtoPayload.toString());
    }

    @Test
    public void testConstructor2() {
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        CreateOrderDtoPayload actualCreateOrderDtoPayload = new CreateOrderDtoPayload(123L, 1L, 10, orderDetails,
                new ArrayList<UserDtoPayload>());
        assertEquals(1L, actualCreateOrderDtoPayload.getCar_type());
        assertEquals(
                "CreateOrderDtoPayload(customerId=123, car_type=1, numOfLoaders=10, orderDetails=OrderDetailsDtoPayload"
                        + "(adressFrom=null, adressTo=null, dateTime=null, timeOnOrder=0.0, loadersCapacity=0, comment=null),"
                        + " extraCustomers=[])",
                actualCreateOrderDtoPayload.toString());
        assertEquals(10, actualCreateOrderDtoPayload.getNumOfLoaders());
        assertEquals(123L, actualCreateOrderDtoPayload.getCustomerId());
    }

    @Test
    public void testEquals() {
        assertFalse((new CreateOrderDtoPayload()).equals("42"));
    }

    @Test
    public void testEquals2() {
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        assertTrue(createOrderDtoPayload.equals(new CreateOrderDtoPayload()));
    }

    @Test
    public void testEquals3() {
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        assertFalse(createOrderDtoPayload
                .equals(new CreateOrderDtoPayload(123L, 1L, 10, orderDetails, new ArrayList<UserDtoPayload>())));
    }

    @Test
    public void testEquals4() {
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload(123L, 1L, 10, orderDetails,
                new ArrayList<UserDtoPayload>());
        OrderDetailsDtoPayload orderDetails1 = new OrderDetailsDtoPayload();
        assertTrue(createOrderDtoPayload
                .equals(new CreateOrderDtoPayload(123L, 1L, 10, orderDetails1, new ArrayList<UserDtoPayload>())));
    }

    @Test
    public void testEquals5() {
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        assertFalse(createOrderDtoPayload
                .equals(new CreateOrderDtoPayload(0L, 1L, 10, orderDetails, new ArrayList<UserDtoPayload>())));
    }

    @Test
    public void testEquals6() {
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload();
        createOrderDtoPayload.setNumOfLoaders(10);
        assertFalse(createOrderDtoPayload.equals(new CreateOrderDtoPayload()));
    }

    @Test
    public void testEquals7() {
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload(123L, 1L, 10, null,
                new ArrayList<UserDtoPayload>());
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        assertFalse(createOrderDtoPayload
                .equals(new CreateOrderDtoPayload(123L, 1L, 10, orderDetails, new ArrayList<UserDtoPayload>())));
    }

    @Test
    public void testEquals8() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L), 10.0f, 1,
                "Comment");
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload(123L, 1L, 10, orderDetails,
                new ArrayList<UserDtoPayload>());
        OrderDetailsDtoPayload orderDetails1 = new OrderDetailsDtoPayload();
        assertFalse(createOrderDtoPayload
                .equals(new CreateOrderDtoPayload(123L, 1L, 10, orderDetails1, new ArrayList<UserDtoPayload>())));
    }

    @Test
    public void testEquals9() {
        ArrayList<UserDtoPayload> userDtoPayloadList = new ArrayList<UserDtoPayload>();
        userDtoPayloadList.add(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example"));
        CreateOrderDtoPayload createOrderDtoPayload = new CreateOrderDtoPayload(123L, 1L, 10, new OrderDetailsDtoPayload(),
                userDtoPayloadList);
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        assertFalse(createOrderDtoPayload
                .equals(new CreateOrderDtoPayload(123L, 1L, 10, orderDetails, new ArrayList<UserDtoPayload>())));
    }

    @Test
    public void testHashCode() {
        assertEquals(714926879, (new CreateOrderDtoPayload()).hashCode());
    }

    @Test
    public void testHashCode2() {
        OrderDetailsDtoPayload orderDetails = new OrderDetailsDtoPayload();
        assertEquals(306083071,
                (new CreateOrderDtoPayload(123L, 1L, 10, orderDetails, new ArrayList<UserDtoPayload>())).hashCode());
    }
}

