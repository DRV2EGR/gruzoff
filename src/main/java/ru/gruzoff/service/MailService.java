package ru.gruzoff.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.User;

/**
 * The type Mail service.
 */
@Service
@Slf4j
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger("emailLogger");

    /**
     * Send.
     *
     * @param emailTo the email to
     * @param subject the subject
     * @param message the message
     */
    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        logger.info("Sended message to " + emailTo + " sbj: " + subject);
        mailSender.send(mailMessage);
    }

    /**
     * Complete registration email string.
     *
     * @param secondName     the second name
     * @param lastName       the last name
     * @param role           the role
     * @param activationCode the activation code
     * @return the string
     */
    public String completeRegistrationEmail(String secondName, String lastName, String role, String activationCode) {
        String message = String.format(
                "Здравствуйте, %s %s! \n" +
                        "Мы рады приветствовать вас на сайте грузоперевозок Gruzoff.\nМы только что получили запрос на регистрацию вас, в качестве " +
                        "%s . \n\n" +
                        "Для подтверждения регистрации, пожалуйста, перейдите по ссылке ниже: \n" +
                        "http://127.0.0.1:8081/v1/api/auth/activate/" + activationCode + " \n\n\n\n\n\n\n" +
                        "Если это были не вы, просто проигнорируйте это письмо." +
                        "С уважением, \nКоманда проекта Gruzoff.",
                secondName, lastName, role
        );

        return message;
    }

    /**
     * Creation order notify string.
     *
     * @param user  the user
     * @param order the order
     * @return the string
     */
    public String creationOrderNotify(User user, Order order) {
        String message = String.format(
                "Здравствуйте, %s %s! \n" +
                    "Вы создали новый заказ №%s Дата: %s. Время в пути заказа: %s"+
                    "От %s до %s .\n" + "Сумма заказа грузоперевозки %s \n" +
                    "Рады сообщить, что уже работаем с поиском исполнителей." +
                    "Как только мы найдем подходящих кандмдатов, наш менеджер с вами свяжется.\n\n\n\n" +
                    "С уважением, \nКоманда проекта Gruzoff.",
                user.getSecondName(), user.getLastName(), order.getId(),
                order.getOrderDetails().getDateTime(), order.getOrderDetails().getTimeOnOrder(),
                order.getOrderDetails().getAdressFrom().toString(),
                order.getOrderDetails().getAdressTo().toString(),
                order.getPrice()
        );

        return message;
    }

    /**
     * Accepted order notify string.
     *
     * @param user  the user
     * @param order the order
     * @return the string
     */
    public String acceptedOrderNotify(User user, Order order) {
        String message = String.format(
                "Здравствуйте, %s %s! \n" +
                        "Ваш заказ №%s успешно подтвержден.Дата: %s. Время в пути заказа: %s"+
                        "Путь от %s до %s .\n" + "Сумма заказа грузоперевозки %s \n" +
                        "Ваш заказ уже принят на исполнение. В назначенную дату () ожидайте наших сотрудников!\n\n\n\n" +
                        "С уважением, \nКоманда проекта Gruzoff.",
                user.getSecondName(), user.getLastName(), order.getId(),
                order.getOrderDetails().getDateTime(), order.getOrderDetails().getTimeOnOrder(),
                order.getOrderDetails().getAdressFrom().toString(),
                order.getOrderDetails().getAdressTo().toString(),
                order.getPrice()
        );

        return message;
    }
}
