package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurityConfiguration {


	
	
	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager  createUserDetailsManager()
	
	{
		
	
		
		
		
		
		
		
		//refactor method
		
		UserDetails userDetails1 = createNewUser("waseem1", "dummy");
		UserDetails userDetails2 = createNewUser("waseem2", "dummy");
		
		//can also support one attribute or multiple InMemoryUserDetailsManager(userDetails1);
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);

	}



	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		=input-> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
		.username(username)
		.password(password)
		.roles("USER","ADMIN")
		.build();
		return userDetails;
	}
	//ctrl+shift +t sortcut to search anything
	// All urls are protected
	//a login form is shown for unauthorized requests
	//CSRF disable
	//frames
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		/////import static org.springframework.security.config.Customizer.withDefaults;
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
				
	}
			
	
		
		
		
	}
	
	

