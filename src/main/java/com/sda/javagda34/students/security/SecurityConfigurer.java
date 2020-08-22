package com.sda.javagda34.students.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("user1").password("{noop}password").roles("USER")
                .and()
                .withUser("user2").password("{noop}password").roles("USER").disabled(true)
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN")
                .and()
                .withUser("superadmin").password("{noop}password").roles("USER", "ADMIN");
    }
}
