package com.example.w3_homework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().antMatchers("/myselectshop/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/user/**");
        http
                .authorizeHttpRequests(authz -> authz
                        .antMatchers("/images/**").permitAll()
                        .antMatchers("/css/**").permitAll()
                        .antMatchers("/user/**").permitAll()
                        .antMatchers(HttpMethod.GET,"/api/post/**").permitAll()
                        // 어떤 요청이든 '인증'
                        .anyRequest().authenticated()
                )
                // 로그인 기능 허용
                .formLogin()
                .loginPage("/user/signin")
                .loginProcessingUrl("/user/signin")
                .defaultSuccessUrl("/")
                .failureUrl("/user/signin?error")
                .permitAll()
                .and()
                //로그아웃 기능 허용
                .logout()
                .logoutUrl("/user/signout")
                .permitAll();

        return http.build();
    }
}
