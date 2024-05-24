package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.PreguntaVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;
import com.dawes.proyecto.servicios.ServicioPregunta;

@RestController
@RequestMapping("/pregunta")
public class PreguntasWS {

	@Autowired
	private ServicioPregunta sp;
	@Autowired
	private ServicioEjercicio se;

	@GetMapping("/buscar/{idEjercicio}")
	public ResponseEntity<?> searchUser(@PathVariable int idEjercicio) {
		try {
			EjercicioVO ej = se.findById(idEjercicio).get();
			List<PreguntaVO> preguntas = sp.findByEjercicio(ej).get();
			return new ResponseEntity<List<PreguntaVO>>(preguntas, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se han encontrado preguntas para el ejercicio con id" + idEjercicio);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
