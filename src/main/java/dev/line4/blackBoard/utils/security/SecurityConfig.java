//package dev.line4.blackBoard.utils.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//// HTTP to HTTPS config
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity https) throws Exception {
//        return https
//                .requiresChannel(channel -> channel.anyRequest().requiresSecure())
//                .authorizeRequests(authorize -> authorize.anyRequest().permitAll())
//                .build();
//    }
//
//}
