package by.gorbov.space.config;

import io.jsonwebtoken.lang.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .formLogin(loginConfig->{
                    loginConfig.loginProcessingUrl("/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/galaxies");

                })
                .logout(logout -> {
                    logout.logoutUrl("/logout");
                })
                .authorizeHttpRequests(auth -> {
                    auth

                            .requestMatchers(
                                    "/logout",
                                    "/login",
                                    "/registration").permitAll()
                            .requestMatchers(
                                    "/planets",
                                    "/planets/change",
                                    "/planets/migration/{fromId}/{toId}",
                                    "/stars",
                                    "/starSystems",
                                    "/galaxies",
                                    "/galaxies/upload",
                                    "/galaxies/download/{id}").authenticated()
                            .requestMatchers(
                                    "/astronomers/addAuthority").hasAuthority("ADMIN");
                })
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
