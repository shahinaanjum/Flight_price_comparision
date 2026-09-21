package com.Flight_Price_Comparision.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Security configuration
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http

            // Disable CSRF for REST API
            .csrf(csrf -> csrf.disable())

            // Enable CORS
            .cors(cors -> {})

            // API authorization
            .authorizeHttpRequests(auth -> auth

                // Public APIs
                .requestMatchers(
                    "/health",
                    "/api/auth/**",
                    "/api/flights/**",
                    "/api/airlines/**",
                    "/api/airports/**"
                ).permitAll()

                // Other APIs require authentication
                .anyRequest().authenticated()
            );

        return http.build();
    }

    // CORS configuration
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration =
                new CorsConfiguration();

        // React frontend URL
        configuration.setAllowedOrigins(
                List.of("http://localhost:5173")
        );

        // Allowed HTTP methods
        configuration.setAllowedMethods(
                List.of(
                    "GET",
                    "POST",
                    "PUT",
                    "DELETE",
                    "OPTIONS"
                )
        );

        // Allow all headers
        configuration.setAllowedHeaders(
                List.of("*")
        );

        // Allow credentials
        configuration.setAllowCredentials(true);

        // Apply CORS configuration to all endpoints
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                configuration
        );

        return source;
    }
}