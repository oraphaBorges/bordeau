package br.com.bordeau.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.bordeau.DAOS.AuthenticationDAO;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationDAO dao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/podcast/novo").access("hasAnyRole('ROLE_USUARIO','ROLE_ADMIN')")
			.antMatchers("/podcast/episodio/novo").access("hasAnyRole('ROLE_CRIADOR','ROLE_ADMIN')")
			.antMatchers("/usuarios/cadastro").not().authenticated()
			.antMatchers("/").permitAll()
			.anyRequest().permitAll()
			.and()
		    	.exceptionHandling().accessDeniedPage("/403error")
			.and()
				.formLogin()
				.loginPage("/login").defaultSuccessUrl("/").permitAll()
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
				.logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(dao)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}
