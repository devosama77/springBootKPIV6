package org.osama.kpi.config;


import org.osama.kpi.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class TopicSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().authenticated()
		http.authorizeRequests()
		.antMatchers("/**").hasAnyRole("ADMIN","USER")
		.antMatchers("login").permitAll()
			//	.anyRequest().permitAll();
				.anyRequest().hasAnyRole("ADMIN","USER")
		.and().formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/app-login")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .defaultSuccessUrl("/")
		.and().logout().permitAll()
		.logoutUrl("/app-logout")
		.logoutSuccessUrl("/login")
		.and().exceptionHandling()
		.accessDeniedPage("/error");
	} 
	
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
       auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}

}