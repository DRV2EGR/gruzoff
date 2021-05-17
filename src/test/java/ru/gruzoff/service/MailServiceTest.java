package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.entity.Adress;
import ru.gruzoff.entity.CarType;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.OrderDetails;
import ru.gruzoff.entity.User;

@ContextConfiguration(classes = {MailService.class})
@ExtendWith(SpringExtension.class)
public class MailServiceTest {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private MailService mailService;

    @Test
    public void testSend() throws MailException {
        doNothing().when(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
        this.mailService.send("jane.doe@example.org", "Hello from the Dreaming Spires", "Not all who wander are lost");
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
    }

    @Test
    public void testCompleteRegistrationEmail() {
        assertEquals(
                "Здравствуйте, Second Name Doe! \n" + "Мы рады приветствовать вас на сайте грузоперевозок Gruzoff.\n"
                        + "Мы только что получили запрос на регистрацию вас, в качестве Role . \n" + "\n"
                        + "Для подтверждения регистрации, пожалуйста, перейдите по ссылке ниже: \n"
                        + "http://127.0.0.1:8081/v1/api/auth/activate/Activation Code \n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
                        + "Если это были не вы, просто проигнорируйте это письмо.С уважением, \n" + "Команда проекта Gruzoff.",
                this.mailService.completeRegistrationEmail("Second Name", "Doe", "Role", "Activation Code"));
    }

    @Test
    public void testCreationOrderNotify() {
        User user = mock(User.class);
        when(user.getLastName()).thenReturn("foo");
        when(user.getSecondName()).thenReturn("foo");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress.setCountry(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress.setTown("Oxford");
        adress.setStreet(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress1.setCountry(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress1.setTown("Oxford");
        adress1.setStreet(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment(
                "Здравствуйте, %s %s! \n" + "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %sОт %s до %s .\n"
                        + "Сумма заказа грузоперевозки %s \n"
                        + "Рады сообщить, что уже работаем с поиском исполнителей.Как только мы найдем подходящих кандмдатов, наш"
                        + " менеджер с вами свяжется.\n" + "\n" + "\n" + "\n" + "С уважением, \n" + "Команда проекта Gruzoff.");
        orderDetails.setLoadersCapacity(0);

        Order order = new Order();
        order.setOrderDetails(orderDetails);
        this.mailService.creationOrderNotify(user, order);
        verify(user).getSecondName();
        verify(user).getLastName();
    }

    @Test
    public void testCreationOrderNotify2() {
        User user = mock(User.class);
        when(user.getLastName()).thenReturn("foo");
        when(user.getSecondName()).thenReturn("foo");

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
        Order order = mock(Order.class);
        when(order.getPrice()).thenReturn(10.0f);
        when(order.getOrderDetails()).thenReturn(orderDetails);
        this.mailService.creationOrderNotify(user, order);
        verify(order, times(4)).getOrderDetails();
        verify(order).getPrice();
        verify(user).getSecondName();
        verify(user).getLastName();
    }

    @Test
    public void testAcceptedOrderNotify() {
        User user = mock(User.class);
        when(user.getLastName()).thenReturn("foo");
        when(user.getSecondName()).thenReturn("foo");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress.setCountry("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress.setTown("Oxford");
        adress.setStreet("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress1.setCountry("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        adress1.setTown("Oxford");
        adress1.setStreet("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment("Здравствуйте, %s %s! \n"
                + "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %sПуть от %s до %s .\n"
                + "Сумма заказа грузоперевозки %s \n"
                + "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n" + "\n" + "\n" + "\n"
                + "С уважением, \n" + "Команда проекта Gruzoff.");
        orderDetails.setLoadersCapacity(0);

        Order order = new Order();
        order.setOrderDetails(orderDetails);
        this.mailService.acceptedOrderNotify(user, order);
        verify(user).getSecondName();
        verify(user).getLastName();
    }

    @Test
    public void testAcceptedOrderNotify2() {
        User user = mock(User.class);
        when(user.getLastName()).thenReturn("foo");
        when(user.getSecondName()).thenReturn("foo");

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
        Order order = mock(Order.class);
        when(order.getPrice()).thenReturn(10.0f);
        when(order.getOrderDetails()).thenReturn(orderDetails);
        this.mailService.acceptedOrderNotify(user, order);
        verify(order, times(4)).getOrderDetails();
        verify(order).getPrice();
        verify(user).getSecondName();
        verify(user).getLastName();
    }
}

