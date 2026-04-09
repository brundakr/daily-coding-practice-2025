package com.SpringStudy.SpringProject.week3.day24.morning;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http
//                .csrf(csrf -> csrf.disable()) //security filter chain 1 - csrf
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/auth/**").permitAll() //anyuser can access any apis starting with /auth. No login permission required
//                        .anyRequest().authenticated() //remaining all other apis require login authentication
//                ) //security filter chain 2 - who can access what
////                .httpBasic(Customizer.withDefaults()); //security filter chain 3 - Use Basic authentication i.e client must send username + password
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();

    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("brunda")
                .password(passwordEncoder().encode("892"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
