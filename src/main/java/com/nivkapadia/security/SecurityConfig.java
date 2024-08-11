package com.nivkapadia.security;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(c -> c.disable()).headers(header -> header.frameOptions(frame -> frame.disable()))
				.authorizeHttpRequests(requests -> requests
						.requestMatchers(antMatcher("/"), antMatcher("/permission-denied"), antMatcher("/error/**"))
						.permitAll()
						.requestMatchers(antMatcher("/admin/**")).hasRole("ADMIN")
						.requestMatchers(antMatcher("/**"), antMatcher("/secure/**")).hasAnyRole("ADMIN", "USER")
						.requestMatchers(antMatcher("/h2-console/**")).permitAll()	
						.requestMatchers(antMatcher("/pass")).permitAll()
						.requestMatchers(antMatcher("/admin/**")).denyAll())
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
						.defaultSuccessUrl("/secure/home", true).permitAll())
				.exceptionHandling(exception -> exception
						.accessDeniedHandler(accessDeniedHandler))
						.logout(logout -> logout
								.invalidateHttpSession(true)
								.clearAuthentication(true).logoutUrl("/logout")
								.logoutSuccessUrl("/login?logout")
						.permitAll());
		return http.build();
	}
	
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
