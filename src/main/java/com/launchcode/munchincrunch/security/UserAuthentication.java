package com.launchcode.munchincrunch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration //this indicates class type
@EnableWebSecurity //this enables/configures web security in app
public class UserAuthentication extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() { //method encode passwords for
        // secure storage in MySQL
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //overridden method used to configure security settings for different
        // HTTP requests
        http
                .authorizeRequests()
                .antMatchers("/", "/public/**").permitAll()
                //indicates requests to the root path ("/") and any path
                // under "/public" is allowed
                // without authentication.
                .anyRequest().authenticated() //indicates any other request
                // should be authenticated.
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
// ("/public") but all other user access require authentication. Form based
// login is enabled with a custom login page, logout is config to redirect to
// root.