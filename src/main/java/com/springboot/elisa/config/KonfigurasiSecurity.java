package com.springboot.elisa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@EnableWebSecurity
@Configuration

public class KonfigurasiSecurity extends WebSecurityConfigurerAdapter{
	
	private static final String SQL_LOGIN = "SELECT username, PASSWORD, active AS enabled  FROM tb_user WHERE username = ?";
	
	private static final String SQL_PERMISSION ="SELECT u.username,r.nama AS authority FROM tb_user u JOIN users_roles ur ON u.id=ur.id_users JOIN roles r " + 
			"ON ur.id_roles=r.id WHERE u.username = ?";
	
	@Autowired private DataSource sd;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth

		.jdbcAuthentication()
		.dataSource(sd)
		.usersByUsernameQuery(SQL_LOGIN)
		.authoritiesByUsernameQuery(SQL_PERMISSION);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	        .antMatchers("/mahasiswa").hasAnyAuthority("ADMIN","STAFF")
	        .antMatchers("/jurusan").hasAuthority("ADMIN")
	        .antMatchers("/fakultas").hasAuthority("ADMIN")
	        .antMatchers("/mahasiswa/create").hasAuthority("ADMIN")
	        .antMatchers("/jurusan/create").hasAuthority("ADMIN")
	        .antMatchers("/fakultas/create").hasAuthority("ADMIN")
	        .antMatchers("/mahasiswa/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/jurusan/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/fakultas/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/mahasiswa/delete/{id}").hasAuthority("ADMIN")
	        .antMatchers("/jurusan/delete/{id}").hasAuthority("ADMIN")
	        .antMatchers("/fakultas/delete/{id}").hasAuthority("ADMIN")
	        .antMatchers("/").hasAnyAuthority("STAFF","ADMIN")
//	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .loginPage("/login").permitAll()
	        //.defaultSuccessUrl("/mahasiswa")
	        .and()
	        .logout()
	        .and()
	        .addFilterAfter(new CsrfFilterCookie(), CsrfFilter.class)
	        .csrf().csrfTokenRepository(csrfTokenRepository());
	           
	}
	private  CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
}
