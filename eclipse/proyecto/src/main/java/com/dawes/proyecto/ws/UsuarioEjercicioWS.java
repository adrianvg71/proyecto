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

import com.dawes.proyecto.modelo.UsuarioEjercicioVO;
import com.dawes.proyecto.servicios.ServicioUsuarioEjercicio;

@RestController
@RequestMapping("/usuarioejercicio")
public class UsuarioEjercicioWS {

	@Autowired
	private ServicioUsuarioEjercicio sue;

	@PostMapping("/insertar")
	private ResponseEntity<?> insertar(@RequestBody UsuarioEjercicioVO usuej) {
		try {
			UsuarioEjercicioVO usuario = sue.save(usuej);
			return new ResponseEntity<UsuarioEjercicioVO>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido insertar el usuarioejercicio " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar")
	private ResponseEntity<?> buscarTodos() {
		try {
			List<UsuarioEjercicioVO> usuarios = sue.findAll();
			return new ResponseEntity<List<UsuarioEjercicioVO>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido buscar los usuarios ejercicios " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
