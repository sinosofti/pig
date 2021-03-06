/*package com.github.pig.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.pig.auth.service.CustomUserService;
import com.github.pig.auth.util.MD5Util;
*//**
 * Created by yangyibo on 17/1/18.
 *//*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }
	// 请配置这个，以保证在刷新Token时能成功刷新
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		// 配置用户来源于数据库
		// 配置密码加密方式 BCryptPasswordEncoder，添加用户加密的时候请也用这个加密
//		auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
	    auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){
        	
        	@Override
        	public String encode(CharSequence rawPassword) {
        		return MD5Util.encode((String)rawPassword);
        	}  
        	@Override
        	public boolean matches(CharSequence rawPassword, String encodedPassword) {
        		return encodedPassword.equals(MD5Util.encode((String)rawPassword));
        	}}); //user Details Service验证
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问


    }



}

*/