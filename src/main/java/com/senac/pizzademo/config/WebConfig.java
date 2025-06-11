package com.senac.pizzademo.config;

import com.senac.pizzademo.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/pizza/*");
        registrationBean.setOrder(1); // Garante prioridade do filtro se houver outros
        return registrationBean;
    }
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(
            "http://localhost:5173",
            "http://127.0.0.1:5173",
            "http://172.17.0.1:5173",
            "http://172.18.0.1:5173",
            "http://10.0.2.15.:5173" // Exemplo: "http://192.168.0.10:5173"
        )
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
    
}
