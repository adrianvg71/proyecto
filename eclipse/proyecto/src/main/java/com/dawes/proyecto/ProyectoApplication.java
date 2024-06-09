package com.dawes.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 * 
 * <p>
 * Esta clase contiene el método main que se utiliza para iniciar la aplicación
 * Spring Boot.
 * </p>
 * 
 * @see org.springframework.boot.SpringApplication
 */
@SpringBootApplication
public class ProyectoApplication {

	/**
	 * Método principal que se utiliza para iniciar la aplicación Spring Boot.
	 * 
	 * @param args los argumentos de línea de comandos (si los hay).
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
