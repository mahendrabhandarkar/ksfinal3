package com.ks.ksfinal3.config;

import com.ks.ksfinal3.security.RefererAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private RefererAuthenticationSuccessHandler refererAuthenticationSuccessHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable) // Consider enabling CSRF protection for non-API endpoints
                .authorizeHttpRequests(
                        authorizationManagerRequestMatcherRegistry -> {
                            authorizationManagerRequestMatcherRegistry.requestMatchers("/**").permitAll()
                                    .dispatcherTypeMatchers(HttpMethod.valueOf("/h2/**")).permitAll() // Allow access to H2 console
                                    .dispatcherTypeMatchers(HttpMethod.valueOf("/register/*")).permitAll()
                                    .dispatcherTypeMatchers(HttpMethod.valueOf("/panel/**/*")).authenticated()
                                    .dispatcherTypeMatchers(HttpMethod.valueOf("/")).permitAll()

                                    .anyRequest().authenticated();
                            }
                )
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.permitAll()
                            .successHandler(refererAuthenticationSuccessHandler)
                            .failureUrl("/login?error=true")
                            .permitAll();
                }
                )
                .logout(httpSecurityLogoutConfigurer -> {
                    httpSecurityLogoutConfigurer.logoutUrl("/logout").permitAll()
                            .logoutSuccessUrl("/login?logout=true")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID")
                            .permitAll();
                }
                );

        // Allow H2 console to be accessed in the browser
        http.headers(headers -> headers
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        return http.build();
    }

    @Bean("passwordEncoder")
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

