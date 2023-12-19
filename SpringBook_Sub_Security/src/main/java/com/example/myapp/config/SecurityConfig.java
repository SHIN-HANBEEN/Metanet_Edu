package com.example.myapp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.headers.HttpPublicKeyPinningDsl;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import com.example.myapp.jwt.JwtAuthenticationFilter;
import com.example.myapp.jwt.JwtTokenProvider;

import jakarta.websocket.Session;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	/*
	 * JwtTokenProvider 를 빈으로 등록합니다.
	 */
	@Bean
	JwtTokenProvider jwtTokenProvider() {
		return new JwtTokenProvider();
	}
	
	/*
	 * JwtAuthenticationFilter 를 빈으로 등록합니다.
	 */
	@Bean
	JwtAuthenticationFilter jwtAuthenticationFilter() {
		/*
		 * JwtAuthenticationFilter 에 @AllArgsConstructor 를 
		 * 사용을 해놓았기 때문에, 생성자를 통한 의존성 주입이 되고 있는 것을
		 * 볼 수 있습니다. 
		 */
		return new JwtAuthenticationFilter(this.jwtTokenProvider());
	}
	
	
	/*
	 * Bean 으로 정의된 것은 public 필요 없습니다.
	 */
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		
//			.formLogin()
//				.loginPage("/member/login")
//				.usernameParameter("userid")
//				.defaultSuccessUrl("/")
//			.and()
//			.logout()
//				.logoutUrl("/member/logout")
//				.logoutSuccessUrl("/member/login")
//				.invalidateHttpSession(true)
//			.and()
//			.exceptionHandling()
//				.accessDeniedPage("/error/403");
		
		
		http.authorizeHttpRequests()
			.requestMatchers("/file/**").hasRole("ADMIN")
			.requestMatchers("/board/**").hasAnyRole("USER", "ADMIN")
			.requestMatchers("/**").permitAll()
			.requestMatchers("/css/**").permitAll()
			.requestMatchers("/js/**").permitAll()
			.requestMatchers("/images/**").permitAll()
			.requestMatchers("/member/insert").permitAll()
			.requestMatchers("/member/login").permitAll();
		
		/*
		 * jwt를 위해 session 을 STATELESS로 설정합니다.
		 * 클라이언트의 고유 값을 Session 에 원래 저장을 하는데,
		 * 우리는 jwt 를 사용하니까 Session 에 
		 * 클라이언트의 고유 상태를 저장하지 않기 위해서, STATELESS 설정을 해주게 됩니다.
		 */
		http.sessionManagement(
				(session) -> 
				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		/*
		 * jwt 를 위해 만들어 놓았던 JwtAuthenticationFilter 를 
		 * UsernamePasswordAuthenticationFilter 전에 사용하도록
		 * 설정을 해줍니다.
		 */
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	@ConditionalOnMissingBean(UserDetailsService.class)
	public InMemoryUserDetailsManager userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withUsername("foo").password("{noop}demo").roles("ADMIN").build(),
				User.withUsername("bar").password("{noop}demo").roles("USER").build(),
				User.withUsername("ted").password("{noop}demo").roles("USER","ADMIN").build());
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}