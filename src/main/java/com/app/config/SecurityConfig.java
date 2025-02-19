package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.identity.TokenUtil;
import com.app.identity.UserDetailsService;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private TokenUtil tokenUtil;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Filters will not get executed for the resources
		web.ignoring().antMatchers("/", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**",
				"/configuration/**", "/swagger-ui/**", "/swagger-resources/**", "/api-docs", "/api-docs/**",
				"/v2/api-docs/**", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg",
				"/**/*.gif", "/**/*.svg", "/**/*.ico", "/**/*.ttf", "/**/*.woff", "/**/*.otf");
	}

	// If Security is not working check application.properties if it is set to
	// ignore
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().and().anonymous().and()
				// Disable Cross site references
				.csrf().disable()
				// Add CORS Filter
				.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
				// Custom Token based authentication based on the header previously given to the
				// client
				.addFilterBefore(new VerifyTokenFilter(tokenUtil), UsernamePasswordAuthenticationFilter.class)
				// custom JSON based authentication by POST of
				// {"username":"<name>","password":"<password>"} which sets the token header
				// upon authentication
				.addFilterBefore(new GenerateTokenForUserFilter("/session", authenticationManager(), tokenUtil),
						UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().anyRequest().authenticated();
	}

	/*
	 * If You want to store encoded password in your databases and authenticate user
	 * based on encoded password then uncomment the below method and provde an
	 * encoder
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Autowired
	
	private PasswordEncoder passwordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new PasswordEnconderTest();
	}
}

class PasswordEnconderTest implements PasswordEncoder {
	@Override
	public String encode(CharSequence charSequence) {
		return charSequence.toString();
	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
		return charSequence.toString().equals(s);
	}
}
