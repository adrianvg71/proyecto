package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.PreguntaVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;
import com.dawes.proyecto.servicios.ServicioPregunta;

/**
 * Controlador REST para la gestión de preguntas.
 */
@RestController
@RequestMapping("/pregunta")
public class PreguntasWS {

	@Autowired
	private ServicioPregunta sp;
	@Autowired
	private ServicioEjercicio se;

	/**
	 * Busca todas las preguntas asociadas a un ejercicio por su ID.
	 * 
	 * @param idEjercicio El ID del ejercicio
	 * @return Una respuesta HTTP que contiene la lista de preguntas asociadas al
	 *         ejercicio
	 */
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

	/**
	 * Busca una pregunta por su ID.
	 * 
	 * @param idPregunta El ID de la pregunta
	 * @return Una respuesta HTTP que contiene la pregunta encontrada
	 */
	@GetMapping("/buscarPorId/{idPregunta}")
	public ResponseEntity<?> searchQuestion(@PathVariable int idPregunta) {
		try {
			PreguntaVO preg = sp.findById(idPregunta).get();
			return new ResponseEntity<PreguntaVO>(preg, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado la pregunta ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Modifica una pregunta existente.
	 * 
	 * @param pregunta La pregunta modificada
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         modificación
	 */
	@PutMapping("/modificar")
	public ResponseEntity<?> modificarPregunta(@RequestBody PreguntaVO pregunta) {
		try {
			Optional<PreguntaVO> preg = sp.findById(pregunta.getIdpregunta());
			PreguntaVO pr;
			if (preg.get() != null) {
				if (pregunta.getEnunciado() != null) {
					preg.get().setEnunciado(pregunta.getEnunciado());
				}
				pr = sp.save(preg.get());
				return new ResponseEntity<PreguntaVO>(pr, HttpStatus.OK);
			} else {
				Map<String, Object> response = new HashMap<>();
				response.put("message", "No se ha podido encontrar la pregunta ");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido modificar la pregunta " + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Crea una nueva pregunta asociada a un ejercicio por su ID.
	 * 
	 * @param pregunta    La pregunta a crear
	 * @param idEjercicio El ID del ejercicio al que se asociará la pregunta
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         creación
	 */
	@PostMapping("/add/{idEjercicio}")
	public ResponseEntity<?> createPreg(@RequestBody PreguntaVO pregunta, @PathVariable Integer idEjercicio) {
		try {
			EjercicioVO ejercicio = se.findById(idEjercicio).get();
			pregunta.setEjercicio(ejercicio);
			PreguntaVO preg = sp.save(pregunta);
			return new ResponseEntity<PreguntaVO>(preg, HttpStatus.OK);
		} catch (Exception ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Error interno del servidor: " + ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Elimina una pregunta por su ID.
	 * 
	 * @param id El ID de la pregunta a eliminar
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         eliminación
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			sp.delete(sp.findById(id).get());
			response.put("message", "Se ha eliminado la pregunta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("message", "No se ha podido eliminar la pregunta " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
