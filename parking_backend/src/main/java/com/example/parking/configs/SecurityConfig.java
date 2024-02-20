package com.example.parking.configs;

import com.example.parking.filter.JwtAuthFilter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.parking.service.UserInfoService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    // User Creation 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoService();
    }

    //     Configuring HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//        .csrf(csrf -> csrf.disable())
//        .authorizeHttpRequests(authorize ->
//            authorize
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                    .requestMatchers(n)// Allow access to static resources
//                    .requestMatchers(new AntPathRequestMatcher("/auth/welcome")).permitAll() // Permit access to these URLs
//                    .requestMatchers(new AntPathRequestMatcher("/auth/addNewUser")).permitAll() // Permit access to these URLs
//                    .requestMatchers(new AntPathRequestMatcher("/auth/generateToken")).permitAll() // Permit access to these URLs
//                    .requestMatchers(new AntPathRequestMatcher("/auth/user/**")).authenticated() // Require authentication for user URLs
//                    .requestMatchers(new AntPathRequestMatcher("/auth/admin/**")).authenticated() // Require authentication for admin URLs
//                    .requestMatchers(new AntPathRequestMatcher("swagger-ui")).permitAll() // Permit access to these URLs
//                    .requestMatchers(new AntPathRequestMatcher("swagger-ui/*")).permitAll() // Permit access to these URLs
//                    .anyRequest().authenticated() // Require authentication for any other requests
//        )
//        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Set session creation policy to stateless
//        .authenticationProvider(authenticationProvider())
//        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        // allow all requests
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll() // Permit access to these URLs
                                .anyRequest().authenticated() // Require authentication for any other requests
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Set session creation policy to stateless
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Password Encoding 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }


    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("My REST API")
                        .description("Some custom description of API.")
                        .version("1.0").contact(new Contact().name("Sallo Szrajbman")
                                .email( "www.baeldung.com").url("salloszraj@gmail.com"))
                        .license(new License().name("License of API")
                                .url("API license URL")
                        )
                );
    }


}