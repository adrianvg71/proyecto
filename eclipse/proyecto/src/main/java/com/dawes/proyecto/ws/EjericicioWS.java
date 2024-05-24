package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;
import com.dawes.proyecto.servicios.ServicioPregunta;
import com.dawes.proyecto.servicios.ServicioUsuario;
import com.dawes.proyecto.servicios.ServicioUsuarioEjercicio;

@RestController
@RequestMapping("/ejercicio")
public class EjericicioWS {

	@Autowired
	private ServicioEjercicio se;
	@Autowired
	private ServicioPregunta sp;
	@Autowired
	private ServicioUsuario su;
	@Autowired
	private ServicioUsuarioEjercicio sue;

	@PostMapping("/insertar")
	private ResponseEntity<?> insertar(@RequestBody EjercicioVO ejercicio) {
		System.out.println(ejercicio);
		try {
			EjercicioVO ejer = se.save(ejercicio);
			return new ResponseEntity<EjercicioVO>(ejer, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido insertar el ejercicio " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar")
	private ResponseEntity<?> buscarTodos() {
		try {
			List<EjercicioVO> ejercicios = se.findAll();
			return new ResponseEntity<List<EjercicioVO>>(ejercicios, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido buscar el ejercicio " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

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

	@GetMapping("/siguiente/{userId}")
	public ResponseEntity<?> searchUser(@PathVariable Integer userId) {
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
}
