package ru.gruzoff.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.gruzoff.security.jwt.JwtConfigurer;
import ru.gruzoff.security.jwt.JwtTokenProvider;

/**
 * The type Security config.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // AUTH ENDPOINTS
    private static final String AUTH_ENDPOINT = "/v1/api/auth/**";
    private static final String SIGNUP_ENDPOINT = "/v1/api/signup/**";

    private static final String PUBLIC_USERS_ENDPOINT = "/v1/api/user/public/**";
    private static final String PRIVATE_USERS_ENDPOINT = "/v1/api/user/private/**";

    private static final String ORDERS_ENDPOINT = "/v1/api/orders/**";

    private static final String WORKERS_ENDPOINT = "/v1/api/worker/**";

    private static final String CARS_ENDPOINT = "/v1/api/cars/**";

    private static final String MANAGER_ENDPOINT = "/v1/api/manager/**";

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Instantiates a new Security config.
     *
     * @param jwtTokenProvider the jwt token provider
     */
    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers(AUTH_ENDPOINT).permitAll()
                    .antMatchers(SIGNUP_ENDPOINT).permitAll()

                    .antMatchers(PUBLIC_USERS_ENDPOINT).permitAll()

                    .antMatchers(ORDERS_ENDPOINT).hasAnyRole("USER", "ADMIN", "MANAGER")
                    .antMatchers("/v1/api/orders/admin/**").hasAnyRole("ADMIN", "MANAGER")

                    .antMatchers(PRIVATE_USERS_ENDPOINT).hasAnyRole("USER", "ADMIN")

                    .antMatchers("/v1/api/worker/driver/**").hasRole("DRIVER")
                    .antMatchers("/v1/api/worker/loader/**").hasRole("LOADER")
                    .antMatchers(WORKERS_ENDPOINT).hasAnyRole("DRIVER", "LOADER")

                    .antMatchers(CARS_ENDPOINT).permitAll()
                    .antMatchers( "/v1/api/cars/private/**").hasAnyRole("DRIVER", "ADMIN", "MANAGER")

                    .antMatchers(MANAGER_ENDPOINT).hasAnyRole("ADMIN", "MANAGER")
                    .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
