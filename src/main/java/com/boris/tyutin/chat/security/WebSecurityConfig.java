package com.boris.tyutin.chat.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoderUtil encoderUtil;
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(@Qualifier("UserDetailsServiceImpl") UserDetailsService userDetailsService,
                             PasswordEncoderUtil encoderUtil) {
        this.userDetailsService = userDetailsService;
        this.encoderUtil = encoderUtil;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/reg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/login")
                .loginProcessingUrl("http://localhost:8080/api/login")
                .defaultSuccessUrl("http://localhost:8080/api/messages", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("http://localhost:8080/api/auth/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("http://localhost:8080/api/login");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setPasswordEncoder(encoderUtil.passwordEncoder());
        dao.setUserDetailsService(userDetailsService);
        return dao;
    }
}
