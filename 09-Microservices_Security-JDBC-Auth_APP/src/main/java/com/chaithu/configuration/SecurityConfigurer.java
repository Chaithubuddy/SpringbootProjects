package com.chaithu.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.chaithu.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MyUserDetailsService userDtlsService;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDtlsService)
			   .passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
		 http
	        .authorizeHttpRequests(req -> req
	        		.requestMatchers("/welcome").permitAll()
	        		.requestMatchers("/user").hasAnyRole("ADMIN","USER")
	        		.requestMatchers("admin").hasAnyRole("ADMIN")
	        		.anyRequest().authenticated()
	       ).formLogin();
	        		

	       
		return http.build();
	}


}
