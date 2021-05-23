package ru.gruzoff.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * The type Mail config.
 */
@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

//    @Value("${spring.mail.port}")
//    private int port;

//    @Value("${spring.mail.protocol}")
//    private String protocol;

    @Value("${mail.debug}")
    private String debug;

    /**
     * Gets mail sender.
     *
     * @return the mail sender
     */
    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(465);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();

//        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);


        return mailSender;
    }
}
