package com.example.TheoriaPortalSite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //pring SecurityのWebセキュリティサポートを有効にし、Webセキュリティの設定を可能にするアノテーション

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
        .requestMatchers("/login").permitAll() //loginページは認証不要
            .anyRequest().authenticated()  //「"/login/**"」以外へのリクエストは認証が必要である
            
        )
        .formLogin(form -> form.loginPage("/login")); //loginページのパス
        return http.build();

    }

}
