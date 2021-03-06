package com.toomuchcoder.api.auth.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

/**
 * packageName: com.toomuchcoder.api.auth.config
 * fileName        : AuthConfiguration.java
 * author          : solyikwon
 * date            : 2022-06-07
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-06-07         solyikwon      최초 생성
 **/
@Configuration//한개만 존재해야함
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS,"*/**").antMatchers("/");//첫번째 화면은 누구든지 볼 수 있게 한다.
        web.httpFirewall(defaultHttpFirewall());// "/"허용
    }

    private HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users/deleteAll").permitAll()
                .antMatchers("/users/findAll").permitAll()
                .antMatchers("/users/count").permitAll()
                .antMatchers("/users/findByToken").permitAll()
                .antMatchers("/users/existsById").permitAll()
                .antMatchers("/users/delete").permitAll()
                .antMatchers("/users/update").permitAll()
                .antMatchers("/users/findById").permitAll()
                .antMatchers("/users/findById").permitAll()
                .antMatchers("/foods//upload").permitAll()
                .anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/users/login");
    }

}
