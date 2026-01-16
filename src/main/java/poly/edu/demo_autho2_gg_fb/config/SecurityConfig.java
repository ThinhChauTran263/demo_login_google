package poly.edu.demo_autho2_gg_fb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * CẤU HÌNH BẢO MẬT - SPRING SECURITY
 * 
 * File này quy định:
 * - Trang nào được truy cập tự do (không cần đăng nhập)
 * - Trang nào bắt buộc phải đăng nhập
 * - Cách thức đăng nhập (OAuth2 với Google)
 * - Xử lý sau khi đăng nhập/đăng xuất
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/error", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/user", true)
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
            )
            .csrf(csrf -> csrf.disable());
        
        return http.build();
    }
}
