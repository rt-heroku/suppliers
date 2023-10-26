package mx.towers.suppliers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

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
			// ...
			.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .and()
            .withUser("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("ADMIN");
    }
}