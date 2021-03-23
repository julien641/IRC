package com.IRC.IRC_Main_server.Config;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.IRC.IRC_Main_server.security.jwt.AuthEntryPointJwt;
import com.IRC.IRC_Main_server.security.jwt.AuthTokenFilter;
import com.IRC.IRC_Main_server.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	@Autowired
    UserDetailsServiceImpl userDetailsService;
	
	
	
	/*
	 @Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registration = new ServletRegistrationBean();
	        registration.addUrlMappings("/h2-console/*");
	        registration.addInitParameter("webAllowOthers", "true");
	        registration.addInitParameter("webPort", "7777");// <-- the port your wish goes here

	        return registration;
	    }
	    */
	
	
	@Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	

    @Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
 
    }
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
	
    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
  
		return new BCryptPasswordEncoder();
	}
    /*
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    */
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/**","/**").permitAll()
			.antMatchers("/api/**","/**").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
    

}