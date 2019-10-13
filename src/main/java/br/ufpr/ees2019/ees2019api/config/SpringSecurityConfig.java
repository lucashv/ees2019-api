package br.ufpr.ees2019.ees2019api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	protected void configureGlobalSecurity(AuthenticationManagerBuilder auth,
							 			   @Qualifier("clienteService") UserDetailsService clienteService) throws Exception {
		auth.userDetailsService(clienteService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
			.antMatchers(HttpMethod.POST, "/api/**").hasRole("USER")
			.antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")
			.antMatchers(HttpMethod.PATCH, "/api/**").hasRole("USER")
			.antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER")
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
}
