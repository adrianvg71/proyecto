package com.dawes.proyecto.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOriginPatterns("*") // Permitir todas las IPs
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
				.allowCredentials(true).maxAge(3600);
	}
}
