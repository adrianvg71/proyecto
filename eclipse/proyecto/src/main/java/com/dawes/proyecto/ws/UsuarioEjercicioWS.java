package com.dawes.proyecto.ws;

import java.util.ArrayList;
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
import com.dawes.proyecto.modelo.UsuarioEjercicioVO;
import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;
import com.dawes.proyecto.servicios.ServicioUsuario;
import com.dawes.proyecto.servicios.ServicioUsuarioEjercicio;

@RestController
@RequestMapping("/usuarioejercicio")
public class UsuarioEjercicioWS {

	@Autowired
	private ServicioUsuarioEjercicio sue;
	@Autowired
	private ServicioUsuario su;
	@Autowired
	private ServicioEjercicio se;

	@PostMapping("/insertar")
	private ResponseEntity<?> insertar(@RequestBody UsuarioEjercicioVO usuej) {
		System.out.println(usuej);
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

	@GetMapping("/buscar/{userId}/{ejerId}")
	private ResponseEntity<?> buscar(@PathVariable Integer userId, @PathVariable Integer ejerId) {
		try {
			UsuarioVO usu = su.findById(userId).get();
			EjercicioVO ejer = se.findById(ejerId).get();
			UsuarioEjercicioVO usej = sue.findByUsuarioAndEjercicio(usu, ejer).get();
			return new ResponseEntity<UsuarioEjercicioVO>(usej, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido buscar los usuarios ejercicios " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{userId}")
	private ResponseEntity<?> buscar(@PathVariable Integer userId) {
		try {
			UsuarioVO usu = su.findById(userId).get();
			List<UsuarioEjercicioVO> usej = sue.findByUsuario(usu).get();
			return new ResponseEntity<List<UsuarioEjercicioVO>>(usej, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido buscar los usuarios ejercicios " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscarpornivel/{userId}/{nivel}")
	private ResponseEntity<?> buscar(@PathVariable Integer userId, @PathVariable String nivel) {
		try {
			UsuarioVO usu = su.findById(userId).get();
			List<EjercicioVO> ejs = se.findByNivel(nivel).get();
			List<UsuarioEjercicioVO> usej = sue.findByUsuario(usu).get();
			List<UsuarioEjercicioVO> usejnivel = new ArrayList<UsuarioEjercicioVO>();
			for (UsuarioEjercicioVO useje : usej) {
				if (useje.getEjercicio().getNivel().equals(nivel)) {
					usejnivel.add(useje);
				}
			}
			return new ResponseEntity<List<UsuarioEjercicioVO>>(usejnivel, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido buscar los usuarios ejercicios " + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
