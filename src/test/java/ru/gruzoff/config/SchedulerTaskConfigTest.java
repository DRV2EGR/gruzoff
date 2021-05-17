package ru.gruzoff.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.repository.RefreshTokenRepository;
import ru.gruzoff.repository.UserRepository;
import ru.gruzoff.security.jwt.JwtTokenProvider;
import ru.gruzoff.service.MailService;
import ru.gruzoff.service.UserService;

@ContextConfiguration(classes = {SchedulerTaskConfig.class})
@ExtendWith(SpringExtension.class)
public class SchedulerTaskConfigTest {
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private MailService mailService;

    @MockBean
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private SchedulerTaskConfig schedulerTaskConfig;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @Test
    public void testClearExpiredRefreshTokens() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        this.schedulerTaskConfig.clearExpiredRefreshTokens();
    }

    @Test
    public void testClearExpiredCodes() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        this.schedulerTaskConfig.clearExpiredCodes();
    }
}

