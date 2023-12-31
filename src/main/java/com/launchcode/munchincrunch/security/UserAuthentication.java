package com.launchcode.munchincrunch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration // indicates class type
@EnableWebSecurity // enables/configures web security in app
public class UserAuthentication extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /**
     Bean method using BCryptPasswordEncoder from Spring Security to create a secure code for passwords.
     This code, difficult to crack, is stored in the database for secure storage.
     During login or password checks, the stored secret code is used to verify and ensure password safety.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //overridden method used to config security settings for HTTP requests
        http
                .authorizeRequests()
                .antMatchers("/", "/public/**").permitAll()
                //Allows access to the root path ("/") and any path
                // under "/public" without authentication.
                .antMatchers("/register").permitAll()
                //User registration allowed without authentication
                .anyRequest().authenticated()
                //indicates any other request requires authentication
                .and()
                .formLogin()//Configures form-based login
                .loginPage("/login")//Specifies the custom login page URL ("/login").
                .permitAll()//Allows users to access the login page
                .and()
                .logout()//Configures logout handling
                .logoutSuccessUrl("/")//Specifies the URL to redirect to after logout
                .permitAll(); //Allows users to perform logout.
    }

}

//This code should allow users access to the root ("/") and any path under
// ("/public") but all other access requires authentication. Form based
// login is enabled with a custom login page, logout is config to redirect to
// root.