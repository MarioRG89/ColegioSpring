package com.mario.colegio.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridadColegio extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
	}
	@Override
	public void configure(WebSecurity web) throws Exception{
		 web.ignoring().antMatchers("/resources/**");
		 
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/listadoalumnos").hasAnyRole("DIRECTOR","SECRETARIO")
		.antMatchers("/formularioactualizaralumnos").hasRole("DIRECTOR")
		.antMatchers("/v1/alumnos").hasRole("DIRECTOR").and().formLogin().loginPage("/login")
		.and().logout().logoutUrl("/haz_logout").logoutSuccessUrl("/login?logout=true")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		;
		
		http.csrf().disable();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
