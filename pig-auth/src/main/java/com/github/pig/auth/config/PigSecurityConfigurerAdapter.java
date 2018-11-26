package com.github.pig.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.pig.auth.component.mobile.MobileSecurityConfigurer;
import com.github.pig.auth.service.CustomUserService;
import com.github.pig.auth.util.MD5Util;
import com.github.pig.common.bean.config.FilterIgnorePropertiesConfig;

/**
 * @author lengleng
 * @date 2018/3/10
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER - 1)
@Configuration
@EnableWebSecurity
public class PigSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;
    @Autowired
    private MobileSecurityConfigurer mobileSecurityConfigurer;
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
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                http.formLogin().loginPage("/authentication/require")
                        .loginProcessingUrl("/authentication/form")
                        .and()
                        .authorizeRequests();
        filterIgnorePropertiesConfig.getUrls().forEach(url -> registry.antMatchers(url).permitAll());
        registry.anyRequest().authenticated()
                .and()
                .csrf().disable();
        http.apply(mobileSecurityConfigurer);
    }
}
