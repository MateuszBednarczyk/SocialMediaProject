package com.maticendrak.socialmediaproject.security;

import com.maticendrak.socialmediaproject.appuser.crudfunctionalities.UserDetailsServiceImpl;
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
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT", "OPTIONS", "PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));

        //login and register security config
        http.authorizeRequests()
                .antMatchers(POST, "/api/user/login")
                .permitAll()
                .antMatchers("http://localhost:8080/")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("http://localhost:8080/")
                .and()
                .logout()
                .logoutSuccessUrl("/");

        //home security config
        http.authorizeRequests()
                .antMatchers("/home")
                .hasAnyAuthority("ROLE_UNVERIFIED", "ROLE_VERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-username")
                .hasAnyAuthority("ROLE_VERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-password")
                .hasAnyAuthority("ROLE_VERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-description")
                .hasAnyAuthority("ROLE_VERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/update-image")
                .hasAnyAuthority("ROLE_VERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/delete-user")
                .hasAnyAuthority("ROLE_UNVERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/send-verification-mail")
                .hasAnyAuthority("ROLE_UNVERIFIED");

        http.authorizeRequests()
                .antMatchers("/api/user/verify")
                .permitAll();

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
