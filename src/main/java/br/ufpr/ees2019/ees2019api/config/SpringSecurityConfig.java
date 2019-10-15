package br.ufpr.ees2019.ees2019api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.ufpr.ees2019.ees2019api.security.JWTAuthenticationFilter;
import br.ufpr.ees2019.ees2019api.security.JWTLoginFilter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	protected void configureGlobalSecurity(AuthenticationManagerBuilder auth,
							 			   @Qualifier("clienteService") UserDetailsService clienteService) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("{noop}admin")
			.roles("ADMIN");
		//auth.userDetailsService(clienteService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()		
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.formLogin().disable();
	}
}
