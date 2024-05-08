package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;

@RestController
@RequestMapping("/ejercicio")
public class EjericicioWS {

	@Autowired
	private ServicioEjercicio se;
	
	@PostMapping("/insertar")
	private ResponseEntity<?> insertar(@RequestBody EjercicioVO ejercicio){
		System.out.println(ejercicio);
		try {
			EjercicioVO ejer = se.save(ejercicio);
			return new ResponseEntity<EjercicioVO>(ejer, HttpStatus.OK);
		} catch(Exception e) {
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
		} catch(Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido buscar el ejercicio " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
