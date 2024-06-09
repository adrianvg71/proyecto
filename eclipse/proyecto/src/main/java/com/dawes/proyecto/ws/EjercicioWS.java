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
import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;
import com.dawes.proyecto.servicios.ServicioUsuario;
import com.dawes.proyecto.servicios.ServicioUsuarioEjercicio;

/**
 * Controlador REST para gestionar los servicios relacionados con los
 * ejercicios.
 */
@RestController
@RequestMapping("/ejercicio")
public class EjercicioWS {

	@Autowired
	private ServicioEjercicio se;

	@Autowired
	private ServicioUsuario su;

	@Autowired
	private ServicioUsuarioEjercicio sue;

	/**
	 * Inserta un nuevo ejercicio en el sistema.
	 * 
	 * @param ejercicio El ejercicio que se va a insertar
	 * @return Una respuesta HTTP que indica el resultado de la operación
	 */
	@PostMapping("/insertar")
	private ResponseEntity<?> insertar(@RequestBody EjercicioVO ejercicio) {
		try {
			EjercicioVO ejer = se.save(ejercicio);
			return new ResponseEntity<EjercicioVO>(ejer, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido insertar el ejercicio: " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca todos los ejercicios disponibles.
	 * 
	 * @return Una respuesta HTTP que contiene una lista de todos los ejercicios
	 */
	@GetMapping("/buscar")
	private ResponseEntity<?> buscarTodos() {
		try {
			List<EjercicioVO> ejercicios = se.findAll();
			return new ResponseEntity<List<EjercicioVO>>(ejercicios, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido buscar el ejercicio: " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca ejercicios por nivel.
	 * 
	 * @param nivel El nivel de los ejercicios a buscar
	 * @return Una respuesta HTTP que contiene una lista de ejercicios del nivel
	 *         especificado
	 */
	@GetMapping("/buscar/{nivel}")
	public ResponseEntity<?> searchUser(@PathVariable String nivel) {
		try {
			List<EjercicioVO> ejs = se.findByNivel(nivel).get();
			return new ResponseEntity<List<EjercicioVO>>(ejs, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado el ejercicio con nivel " + nivel);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca un ejercicio por su ID.
	 * 
	 * @param id El ID del ejercicio a buscar
	 * @return Una respuesta HTTP que contiene el ejercicio encontrado, si existe
	 */
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<?> searchExerciseById(@PathVariable Integer id) {
		try {
			EjercicioVO ej = se.findById(id).get();
			return new ResponseEntity<EjercicioVO>(ej, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado el ejercicio");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca el siguiente ejercicio disponible para un usuario.
	 * 
	 * @param userId El ID del usuario
	 * @return Una respuesta HTTP que contiene el siguiente ejercicio disponible
	 *         para el usuario
	 */
	@GetMapping("/siguiente/{userId}")
	public ResponseEntity<?> searchNextExerciseForUser(@PathVariable Integer userId) {
		try {
			UsuarioVO usu = su.findById(userId).get();
			List<EjercicioVO> ejs = se.findByNivel(usu.getNivel()).get();
			if (ejs.size() == 1) {
				return new ResponseEntity<EjercicioVO>(ejs.get(0), HttpStatus.OK);
			} else {
				EjercicioVO ejer = null;
				for (EjercicioVO ej : ejs) {
					if (sue.findByUsuarioAndEjercicio(usu, ej).isEmpty()) {
						ejer = ej;
						break;
					}
				}
				return new ResponseEntity<EjercicioVO>(ejer, HttpStatus.OK);
			}
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado el ejercicio para el usuario " + userId);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Modifica un ejercicio existente.
	 * 
	 * @param ejercicio El ejercicio con los cambios a aplicar
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         modificación
	 */
	@PutMapping("/modificar")
	public ResponseEntity<?> modifyExercise(@RequestBody EjercicioVO ejercicio) {
		try {
			Optional<EjercicioVO> ej = se.findById(ejercicio.getIdejercicio());
			EjercicioVO ejer;
			if (ej.get() != null) {
				if (ejercicio.getNombre() != null) {
					ej.get().setNombre(ejercicio.getNombre());
				}
				if (ejercicio.getIdioma() != null) {
					ej.get().setIdioma(ejercicio.getIdioma());
				}
				if (ejercicio.getNivel() != null) {
					ej.get().setNivel(ejercicio.getNivel());
				}
				ejer = se.save(ej.get());
				return new ResponseEntity<EjercicioVO>(ejer, HttpStatus.OK);
			} else {
				Map<String, Object> response = new HashMap<>();
				response.put("message", "No se ha podido encontrado el ejercicio ");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido modificar el ejercicio " + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Crea un nuevo ejercicio.
	 * 
	 * @param ejercicio El nuevo ejercicio a crear
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         creación
	 */
	@PostMapping("/add")
	public ResponseEntity<?> createExercise(@RequestBody EjercicioVO ejercicio) {
		try {
			EjercicioVO ejer = se.save(ejercicio);
			return new ResponseEntity<EjercicioVO>(ejer, HttpStatus.OK);
		} catch (Exception ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Error interno del servidor: " + ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Elimina un ejercicio existente.
	 * 
	 * @param id El ID del ejercicio a eliminar
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         eliminación
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteExercise(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			se.delete(se.findById(id).get());
			response.put("message", "Se ha eliminado el ejercicio");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("message", "No se ha podido eliminar el ejercicio " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
