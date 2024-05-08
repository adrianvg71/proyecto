package com.dawes.proyecto.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.servicios.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioWS {

	@Autowired
	private ServicioUsuario su;
	@PostMapping("/registro")
	public ResponseEntity<?> createUser(@RequestBody UsuarioVO usuario) {
		try {
			UsuarioVO usu = su.save(usuario);
			return new ResponseEntity<UsuarioVO>(usu, HttpStatus.OK);
	    } catch (DataIntegrityViolationException ex) {
	        // Si se produce una excepción de violación de integridad de datos (correo duplicado, por ejemplo)
	        // Devolver un mensaje de error específico y un código de estado HTTP 409 Conflict
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "El correo electrónico ya está en uso.");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
	    } catch (Exception ex) {
	        // Manejar cualquier otra excepción y devolver un error interno del servidor
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "Error interno del servidor: " + ex.getMessage());
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificarUsuario(@RequestBody UsuarioVO usuario) {
		System.out.println(usuario + " #######################################");
		try {
			Optional<UsuarioVO> usu = su.findByCorreo(usuario.getCorreo());
			System.out.println(usu.get());
			UsuarioVO user;
			if(usu.get() != null) {
				usu.get().setNombre(usuario.getNombre());
				usu.get().setNivel(usuario.getNivel());
				usu.get().setTipo(usuario.getTipo());
				usu.get().setIdioma(usuario.getIdioma());
				user = su.save(usu.get());
				return new ResponseEntity<UsuarioVO>(user, HttpStatus.OK);
			}
			else {
				Map<String, Object> response = new HashMap<>();
				response.put("message", "No se ha podido encontrado el usuario");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch(Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido modificar el usuario " + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<?> searchAll() {
		try {			
			List<UsuarioVO> usuarios = su.findAll();
			return new ResponseEntity<List<UsuarioVO>>(usuarios, HttpStatus.OK);
		} catch(Exception ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado los ususarios " + ex.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar/{correo}")
	public ResponseEntity<?> searchUser(@PathVariable String correo) {
		try {			
			UsuarioVO usu = su.findByCorreo(correo).get();
			return new ResponseEntity<UsuarioVO>(usu, HttpStatus.OK);
		} catch(Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado ese usuario " + e.getCause());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/borrar/{correo}")
	public ResponseEntity<?> deleteUser(@PathVariable String correo) {
		Map<String,Object> response = new HashMap<>();
		try {			
			su.delete(su.findByCorreo(correo).get());
			response.put("message", "Se ha eliminado el usuario");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("message", "No se ha podido eliminar el usuario " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
