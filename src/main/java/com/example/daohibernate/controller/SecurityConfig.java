package com.example.daohibernate.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Andrey").password("{noop}password").authorities("admin")
                .and()
                .withUser("Vadim").password("{noop}password2").authorities("city")
                .and()
                .withUser("Alexey").password("{noop}password3").authorities("read")
                .and()
                .withUser("Maxim").password("{noop}password4").authorities("write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers("/persons/new-person").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/persons/by-city", "/persons/by-age-less").hasAuthority("city")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/by-id", "/persons", "/persons/by-name-and-surname").hasAuthority("read")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/update-phone-by-id", "/persons/delete-by-id").hasAuthority("write")
                .and()
                .authorizeHttpRequests().antMatchers(
                        "/persons/new-person",
                        "/persons/by-city",
                        "/persons/by-age-less",
                        "/persons/by-id",
                        "/persons",
                        "/persons/by-name-and-surname",
                        "/persons/update-phone-by-id",
                        "/persons/delete-by-id"
                ).hasAuthority("admin");
    }
}
