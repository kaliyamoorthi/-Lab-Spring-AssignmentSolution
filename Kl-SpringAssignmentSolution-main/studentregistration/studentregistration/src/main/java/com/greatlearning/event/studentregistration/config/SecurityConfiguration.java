package com.greatlearning.fest.studentreg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // By writing the below configuration, we are storing our in memory password
        // using BCrypt, FYI: this is recommended for Prod env
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // In-memory authentication, method chaining
        auth.inMemoryAuthentication()
//                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
//				.withUser("user").password(encoder.encode("user")).roles("USER");
                .withUser("admin").password("admin").roles("ADMIN").and()
                .withUser("user").password("user").roles("USER");
    }
    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/fest/Student", "/fest/showStudentform","/fest/delete").hasAnyRole("ADMIN")
                .antMatchers("/fest","/event/list", "/fest/updateForm", "/fest/update").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                //.antMatchers("com.greatlearning.fest/").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                //.successForwardUrl("/fest/homepage").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/fest/403")
                .and()
                .cors().and().csrf().disable();
    }

}

