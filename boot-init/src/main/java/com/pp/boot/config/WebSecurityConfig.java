package com.pp.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * Spring Security 配置类
 * @author supanpan
 * @create 2024/05/08 12:48
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 允许访问的路径
//                .antMatchers("/", "/index").permitAll()
                // 其他请求全部需要验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 登录页面
                .loginPage("/login.html")
                // 登录处理请求
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/index")
                .failureUrl("/login.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();
        // 关闭跨站请求伪造
        http.csrf().disable();
    }

}
