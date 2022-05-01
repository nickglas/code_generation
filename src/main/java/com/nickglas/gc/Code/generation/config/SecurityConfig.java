package com.nickglas.gc.Code.generation.config;

import com.nickglas.gc.Code.generation.filter.AuthenticationFilter;
import com.nickglas.gc.Code.generation.filter.AuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter authFilter = configureAuthenticationFilter();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        configureUnprotectedRoutes(http);
        configureProtectedRoutes(http);
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(authFilter);
        http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    private AuthenticationFilter configureAuthenticationFilter() throws Exception {
        AuthenticationFilter authFilter = new AuthenticationFilter(authenticationManagerBean());
        authFilter.setFilterProcessesUrl("/v1/auth/login");
        return authFilter;
    }

    //Configure unprotected routes (everyone can access them)
    private void configureUnprotectedRoutes(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/v1/auth/login/**", "/v1/auth/refresh/**").permitAll();
    }

    //configure the routes with associated roles
    private void configureProtectedRoutes(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(GET, "/v1/user/**").hasAnyAuthority("USER", "EMPLOYEE");
        http.authorizeRequests().antMatchers(GET, "/v1/role/**").hasAnyAuthority( "EMPLOYEE");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}