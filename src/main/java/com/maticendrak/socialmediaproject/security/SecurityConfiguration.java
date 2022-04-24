package com.maticendrak.socialmediaproject.security;

import com.maticendrak.socialmediaproject.appUser.functionalities.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@RequiredArgsConstructor
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;
    private final SufixConfiguration sufixConfiguration;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(sufixConfiguration.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));

        //login and register security config
        http.authorizeRequests()
                .antMatchers(POST, "/api/user/login")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/home#/login")
                .defaultSuccessUrl("/home#/home", true)
                .and()
                .logout()
                .logoutSuccessUrl("/home");

        //home security config
        http.authorizeRequests()
                .antMatchers("/home#/home")
                .hasAnyAuthority("ROLE_NOTVERIFICATED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-username")
                .hasAuthority("ROLE_NOTVERIFICATED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-password")
                .hasAuthority("ROLE_NOTVERIFICATED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-description")
                .hasAuthority("ROLE_NOTVERIFICATED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-image")
                .hasAuthority("ROLE_NOTVERIFICATED");

        http.authorizeRequests()
                .antMatchers("/api/user/delete-user")
                .hasAuthority("ROLE_NOTVERIFICATED");

        //jwt authentication config
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/api/user/login");
        http.addFilter(authenticationFilter);
        http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.headers().cacheControl();
        http.csrf().disable();
        http.cors();

        //session management
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}
