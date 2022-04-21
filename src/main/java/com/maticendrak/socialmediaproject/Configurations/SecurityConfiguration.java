package com.maticendrak.socialmediaproject.Configurations;

import com.maticendrak.socialmediaproject.Filters.AuthenticationFilter;
import com.maticendrak.socialmediaproject.Services.AppUser.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;
    private final SufixConfiguration sufixConfiguration;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(sufixConfiguration.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/user/login");

        http.authorizeRequests().antMatchers(POST, "/user/login");
        http.authorizeRequests().antMatchers("/home#/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/home#/login")
                .defaultSuccessUrl("/home#/home", true)
                .and()
                .logout()
                .logoutSuccessUrl("/home");

        http.authorizeRequests().antMatchers("/home#/home").hasAnyAuthority("ROLE_USER");
        http.addFilter(authenticationFilter);

        http.csrf().disable();
        http.cors().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
