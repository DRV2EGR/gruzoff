package ru.gruzoff.security.jwt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtTokenProvider.class, JwtConfigurer.class})
@ExtendWith(SpringExtension.class)
public class JwtConfigurerTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    @Test
//    public void testConstructor() {
//        // TODO:
//
//        new JwtConfigurer(this.jwtTokenProvider);
//    }
}

