package com.mg.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JwtFilter jwtFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("--------------------------------------------------------------------------------------------");
		//System.out.println("m"+myUserDetailsService.loadUserByUsername("varun"));
		System.out.println("--------------------------------------------------------------------------------------------");
		auth.userDetailsService(myUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().cors().and().
		authorizeRequests().antMatchers("/config-service/token/**").permitAll()
			.antMatchers("/tokenBySiteId/**").permitAll()
			.antMatchers("/config-service/swagger-ui.html/**").permitAll()
			.antMatchers("/saveuser/**").permitAll()
			.antMatchers("/config-service/token/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).httpBasic();
		
		
		
	/*	httpSecurity.
		     cors().and().csrf().disable()
		            .authorizeRequests()                                                                
		            .antMatchers("/**").permitAll()
		            .antMatchers("/login").hasRole("ADMIN")                                      
		            .antMatchers("/Signup").hasRole("USER")
		            .and()
		            .exceptionHandling()
		            .accessDeniedPage("/access-denied")
		            .and()
		            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
		            .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailService));*/
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources/**",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/actuator/**",
                                   "/webjars/**");
    }
    
}