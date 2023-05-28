package com.example.springapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class ApplSecurityConfig {
	
	@Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	 http
	        .csrf().disable()
	        .authorizeHttpRequests()
	        .antMatchers("/workout","/set","/exercise").permitAll()
	        .and()
	        .authorizeHttpRequests()
	        .antMatchers("/user/register").hasAuthority("ADMIN")
	        .anyRequest().authenticated()
	        .and()
			.formLogin()
			.and()
			.httpBasic()
			.and()
			.logout((logout)->logout.permitAll());
	return http.build();
    }

	@Bean
	public UserDetailsService userDetailsService() {
		//UserDetails user=User.withDefaultPasswordEncoder().username("sound").password("123").roles("USER").build();
		return new MyUserDetailsService();
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authentictaionProvider()
	{
	   DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();	
	   authenticationProvider.setUserDetailsService(userDetailsService());
	   authenticationProvider.setPasswordEncoder(passwordEncoder());
	   return authenticationProvider;
	   
	}
}
