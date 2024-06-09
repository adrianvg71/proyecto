package com.dawes.proyecto.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para redireccionar a las páginas de administración de preguntas y
 * opciones.
 */
@Controller
public class Admin_preguntasWS {

	/**
	 * Método para redireccionar a la página de administración de preguntas.
	 * 
	 * @return La ruta hacia la página de administración de preguntas
	 */
	@GetMapping("/admin-preguntas/{loquesea}")
	public String mostrarPagina() {
		return "forward:/admin-preguntas.html";
	}

	/**
	 * Método para redireccionar a la página de administración de opciones.
	 * 
	 * @return La ruta hacia la página de administración de opciones
	 */
	@GetMapping("/admin-opciones/{loquesea}")
	public String mostrarPagina2() {
		return "forward:/admin-opciones.html";
	}
}
