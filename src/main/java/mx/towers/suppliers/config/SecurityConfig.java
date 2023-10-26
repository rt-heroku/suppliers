package mx.towers.suppliers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  
{


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .successForwardUrl("/index")
//            .and()
//            .logout()
//            .permitAll()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("/login");
//        return http.build();
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();
//    }

//	  @Bean
//	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    return 
//	    		http
//	        .authorizeHttpRequests(customizer -> customizer
//	            .requestMatchers("/**").authenticated()
//	            .requestMatchers(HttpMethod.POST, "/api/accounts/**").permitAll()
//	            .anyRequest().authenticated()
//	            )
////	        .exceptionHandling(customizer -> customizer
////	            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
//	        .csrf(AbstractHttpConfigurer::disable)
//          .formLogin(formlogin -> formlogin
//          .loginPage("/login")
//          .permitAll()
//          .successForwardUrl("/index"))
//          .logout(l -> l.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login"))
//        .build();
//	  }
	  
	@Bean
	public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
//					.requestMatchers("/sign-in").permitAll()
					.anyRequest().authenticated()
				)
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
//			.formLogin(formlogin -> formlogin.loginPage("/sign-in"))
//				.logout(l -> l.logoutRequestMatcher(new AntPathRequestMatcher("/sign-out.html"))
//						.logoutSuccessUrl("/sign-in.html"))
		;
		return http.build();
	}	
	@Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	}

	@Autowired PasswordEncoder encoder;
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails =User.withUsername("user")
			.password(encoder.encode("password"))
			.roles("USER")
			.build();

		return new InMemoryUserDetailsManager(userDetails);
	}

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user")
//            .password(passwordEncoder.encode("password"))
//            .roles("USER")
//            .and()
//            .withUser("admin")
//            .password(passwordEncoder.encode("admin"))
//            .roles("ADMIN");
//    }
}