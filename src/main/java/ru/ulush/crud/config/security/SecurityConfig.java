package ru.ulush.crud.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("user").password("user123").roles("USER"))
                .withUser(users.username("ulush").password("admin123").roles("USER","ADMIN"));


     }

    //Метод для кастомизации loginPage
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                    .antMatchers("/").hasRole("USER")
                    .antMatchers("/people/**").hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/showLoginPage") //Указывается URL из браузера
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                    .logout().permitAll() //Добавляем Logout
                .and()
                    .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
