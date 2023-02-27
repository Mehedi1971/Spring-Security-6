package com.mahedi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mahedi.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserInfoUserDetailsService();
	    }
	 
	 @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }

	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 
	
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	         http.csrf().disable()
	                .authorizeHttpRequests()
//	                .requestMatchers("/admin/**").permitAll()
	                .requestMatchers("/save-user","/all-user").hasAnyRole("ADMIN")
	                .requestMatchers("/dashboard").hasAnyRole("DOCTOR","ADMIN")
	                .requestMatchers("/public/**").hasAnyRole("SUPPORT_ENGINEER","ADMIN")
	                .anyRequest()
	                .authenticated()
	                .and()
	                .formLogin();
	               
	                return http.build();
	    }
	  
	  

}
