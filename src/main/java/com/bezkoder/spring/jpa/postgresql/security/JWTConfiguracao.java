package com.bezkoder.spring.jpa.postgresql.security;

import com.bezkoder.spring.jpa.postgresql.service.DetalheUsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static com.bezkoder.spring.jpa.postgresql.enums.Permissao.USER_FREE;


import static com.bezkoder.spring.jpa.postgresql.enums.Permissao.ADMIN;

@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    private final DetalheUsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    public JWTConfiguracao(DetalheUsuarioServiceImpl usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login", "/api/v1/usuario/register").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/fiis/**", "/api/v1/opcoes/**", "/api/v1/acoes/**", "/api/v1/acao-usuario/**").hasAnyRole("USUARIO", "ADMINISTRADOR", "USUARIO_PLUS", "USUARIO_PREMIUM")
                .antMatchers(HttpMethod.POST, "/api/v1/fiis/**", "/api/v1/acoes/**").hasAnyRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.POST, "/api/v1/opcoes/**", "/api/v1/acao-usuario/**").hasAnyRole("USUARIO", "ADMINISTRADOR", "USUARIO_PLUS", "USUARIO_PREMIUM")
                .antMatchers(HttpMethod.DELETE, "/api/v1/opcoes/**", "/api/v1/acao-usuario/**").hasAnyRole("USUARIO", "ADMINISTRADOR", "USUARIO_PLUS", "USUARIO_PREMIUM")
                .antMatchers(HttpMethod.PUT, "/api/v1/opcoes/**", "/api/v1/acao-usuario/**").hasAnyRole("USUARIO", "ADMINISTRADOR", "USUARIO_PLUS", "USUARIO_PREMIUM")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAutenticarFilter(authenticationManager()))
                .addFilter(new JWTValidarFilter(authenticationManager(), usuarioService))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout()
                .logoutUrl("/api/v1/auth/logout");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}











