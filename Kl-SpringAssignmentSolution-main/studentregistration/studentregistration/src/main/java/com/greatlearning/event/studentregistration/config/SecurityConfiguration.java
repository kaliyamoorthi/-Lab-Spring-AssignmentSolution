package com.greatlearning.event.studentregistration.config;

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
        http.authorizeRequests().antMatchers("/event/registerStudent", "/event/showStudentform","/event/delete").hasAnyRole("ADMIN")
                .antMatchers("/event","/event/list", "/event/updateForm", "/event/update").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                //.antMatchers("com.greatlearning.event/").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                //.successForwardUrl("/event/homepage").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/event/403")
                .and()
                .cors().and().csrf().disable();
    }

}

