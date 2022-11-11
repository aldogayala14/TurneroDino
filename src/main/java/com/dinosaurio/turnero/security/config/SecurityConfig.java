package com.dinosaurio.turnero.security.config;


import com.dinosaurio.turnero.security.filter.JwtRequestFilter;
import com.dinosaurio.turnero.security.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {


    private UserDetailsCustomService userDetailsCustomService;
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(@Lazy UserDetailsCustomService userDetailsCustomService,
                          @Lazy JwtRequestFilter jwtRequestFilter){
        this.userDetailsCustomService = userDetailsCustomService;
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
       return httpSecurity.csrf().disable()
                .authorizeHttpRequests( auth -> {
                            auth.antMatchers(HttpMethod.GET, "/API/auth/**").permitAll();
                            auth.antMatchers(HttpMethod.GET, "/sucursales/all").hasAnyRole("ADMIN");
                            auth.anyRequest().authenticated();
                        })
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }


    @Bean
    public AuthenticationManager authicationManager(HttpSecurity httpSecurity) throws Exception{

            return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                    .userDetailsService(userDetailsCustomService)
                    .passwordEncoder(this.passwordEncoder())
                    .and()
                    .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
