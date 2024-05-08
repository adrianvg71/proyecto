package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.proyecto.modelo.HashKey;
import com.dawes.proyecto.servicios.ServicioHashKey;

@RestController
@RequestMapping("/hash")
public class HashKeyWS {

	@Autowired
	private ServicioHashKey sh;

	@GetMapping("/get")
	private ResponseEntity<?> getKey() {
		try {
			HashKey hk = sh.findById(1).get();
			return new ResponseEntity<String>(hk.getKey(), HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "no se ha podido encontrar la clave " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
