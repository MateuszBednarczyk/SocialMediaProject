package com.maticendrak.socialmediaproject.Configurations;

import com.maticendrak.socialmediaproject.Services.AppUser.UserDetailsServiceImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;
    private SufixConfiguration sufixConfiguration;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService, SufixConfiguration sufixConfiguration) {
        this.userDetailsService = userDetailsService;
        this.sufixConfiguration = sufixConfiguration;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(sufixConfiguration.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //ACCESS TO ENDPOINTS
        http.authorizeRequests().antMatchers("/user").permitAll();

        //LOGIN AND LOGOUT CONFIG
        http.formLogin().disable();
        http.logout().disable();

        //SECURITY
        http.cors().disable();
        http.csrf().disable();
    }
}
