package com.sda.javagda34.students.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public SecurityConfigurer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/student/list").authenticated()
                .antMatchers(HttpMethod.GET, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/grade").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/grade").hasAuthority("ADMIN");




    }
}
