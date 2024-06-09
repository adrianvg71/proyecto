package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.proyecto.modelo.OpcionVO;
import com.dawes.proyecto.modelo.PreguntaVO;
import com.dawes.proyecto.servicios.ServicioOpcion;
import com.dawes.proyecto.servicios.ServicioPregunta;

/**
 * Controlador REST para la gestión de opciones.
 */
@RestController
@RequestMapping("/opcion")
public class OpcionWS {

	@Autowired
	private ServicioOpcion so;
	@Autowired
	private ServicioPregunta sp;

	/**
	 * Modifica una opción existente.
	 * 
	 * @param opcion La opción modificada
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         modificación
	 */
	@PutMapping("/modificar")
	public ResponseEntity<?> modificarPregunta(@RequestBody OpcionVO opcion) {
		try {
			Optional<OpcionVO> op = so.findById(opcion.getIdopcion());
			OpcionVO opc;
			if (op.get() != null) {
				if (opcion.getDescripcion() != null) {
					op.get().setDescripcion(opcion.getDescripcion());
				}
				if (opcion.getCorrecta() != null) {
					op.get().setCorrecta(opcion.getCorrecta());
				}
				opc = so.save(op.get());
				return new ResponseEntity<OpcionVO>(opc, HttpStatus.OK);
			} else {
				Map<String, Object> response = new HashMap<>();
				response.put("message", "No se ha podido encontrar la opcion ");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido modificar la pregunta " + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Crea una nueva opción asociada a una pregunta por su ID.
	 * 
	 * @param opcion     La opción a crear
	 * @param idPregunta El ID de la pregunta a la que se asociará la opción
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         creación
	 */
	@PostMapping("/add/{idPregunta}")
	public ResponseEntity<?> createPreg(@RequestBody OpcionVO opcion, @PathVariable Integer idPregunta) {
		try {
			PreguntaVO pregunta = sp.findById(idPregunta).get();
			opcion.setPregunta(pregunta);
			OpcionVO op = so.save(opcion);
			return new ResponseEntity<OpcionVO>(op, HttpStatus.OK);
		} catch (Exception ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Error interno del servidor: " + ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Elimina una opción por su ID.
	 * 
	 * @param id El ID de la opción a eliminar
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         eliminación
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			so.delete(so.findById(id).get());
			response.put("message", "Se ha eliminado la opcion");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("message", "No se ha podido eliminar la opcion " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
