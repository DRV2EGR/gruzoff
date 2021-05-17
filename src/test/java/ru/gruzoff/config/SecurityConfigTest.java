package ru.gruzoff.config;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.security.jwt.JwtTokenProvider;

@ContextConfiguration(classes = {SecurityConfig.class, JwtTokenProvider.class, AuthenticationManagerBuilder.class})
@ExtendWith(SpringExtension.class)
public class SecurityConfigTest {
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

//    @Autowired
//    private ObjectPostProcessor<Object> objectPostProcessor;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    @Test
//    public void testAuthenticationManagerBean() throws Exception {
//        // TODO:
//
//        (new SecurityConfig(this.jwtTokenProvider)).authenticationManagerBean();
//    }

//    @Test
//    public void testConfigure() throws Exception {
//        // TODO:
//
//        SecurityConfig securityConfig = new SecurityConfig(this.jwtTokenProvider);
//        securityConfig.configure(new HttpSecurity(this.objectPostProcessor, this.authenticationManagerBuilder,
//                new HashMap<Class<?>, Object>(1)));
//    }
}

