package com.bit.university;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/image/**", "/lib/**").anyRequest();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 페이지 권한 설정
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .mvcMatchers("/login/**").authenticated()
                .mvcMatchers("/","/**").permitAll()
            .and() // 로그인 설정
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/main")
                .usernameParameter("std_no")
                .passwordParameter("std_pwd")
                .permitAll()
            .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true);
    }
}