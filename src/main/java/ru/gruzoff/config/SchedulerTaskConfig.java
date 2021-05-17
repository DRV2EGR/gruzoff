package ru.gruzoff.config;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.gruzoff.entity.RefreshToken;
import ru.gruzoff.entity.User;
import ru.gruzoff.repository.RefreshTokenRepository;
import ru.gruzoff.repository.UserRepository;
import ru.gruzoff.security.jwt.JwtTokenProvider;
import ru.gruzoff.service.MailService;
import ru.gruzoff.service.UserService;

@Configuration
@EnableScheduling
@Slf4j
public class SchedulerTaskConfig {
    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    Logger logger = LoggerFactory.getLogger("schedulerLog");

    @Scheduled(cron = "${job.cron.rate}")
    public void clearExpiredRefreshTokens() {
        List<RefreshToken> rt = refreshTokenRepository.findAll(); //TODO: use sql

        Date now = new Date();
        logger.info("Expired refresh tokens cleaned on " + now);

        for (RefreshToken token : rt) {
            try {
                jwtTokenProvider.validateRefreshToken(token.getRefreshToken());
            } catch (IllegalArgumentException e) {
                refreshTokenRepository.delete(token);
            }
        }
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void clearExpiredCodes() {
        logger.info("Activation canceling started!");
        for(Optional<User> _user : userRepository.findAllByActivationCodeNotNull()) {
            User user = _user.get();;

            if (!user.getCreatedActivationCode().plusMinutes(15).isAfter(LocalDateTime.now()) ) {
                mailService.send(user.getEmail(), "Отмена активации.", "Вы не подтвердили аккаунт.\nВаша регистрация удалена.\n\n\n\n\nС уважением,\nкоманда проекта *sitename*.");
                userRepository.delete(user);
            }
        }
    }
}
