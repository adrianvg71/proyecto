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

/**
 * Controlador REST para la gestión de usuarios.
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioWS {

	@Autowired
	private ServicioUsuario su;

	/**
	 * Crea un nuevo usuario.
	 * 
	 * @param usuario El usuario a crear
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         creación
	 */
	@PostMapping("/registro")
	public ResponseEntity<?> createUser(@RequestBody UsuarioVO usuario) {
		try {
			UsuarioVO usu = su.save(usuario);
			return new ResponseEntity<UsuarioVO>(usu, HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "El correo electrónico ya está en uso.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		} catch (Exception ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Error interno del servidor: " + ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Modifica un usuario existente.
	 * 
	 * @param usuario El usuario con los cambios a aplicar
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         modificación
	 */
	@PutMapping("/modificar")
	public ResponseEntity<?> modifyUser(@RequestBody UsuarioVO usuario) {
		try {
			Optional<UsuarioVO> usu = su.findById(usuario.getIdusuario());
			UsuarioVO user;
			if (usu.get() != null) {
				// Aplicar cambios si los campos no son nulos
				if (usuario.getNombre() != null) {
					usu.get().setNombre(usuario.getNombre());
				}
				if (usuario.getCorreo() != null) {
					usu.get().setCorreo(usuario.getCorreo());
				}
				if (usuario.getContraseña() != null) {
					usu.get().setContraseña(usuario.getContraseña());
				}
				if (usuario.getNivel() != null) {
					usu.get().setNivel(usuario.getNivel());
				}
				if (usuario.getTipo() != null) {
					usu.get().setTipo(usuario.getTipo());
				}
				if (usuario.getIdioma() != null) {
					usu.get().setIdioma(usuario.getIdioma());
				}
				user = su.save(usu.get());
				return new ResponseEntity<UsuarioVO>(user, HttpStatus.OK);
			} else {
				Map<String, Object> response = new HashMap<>();
				response.put("message", "No se ha encontrado el usuario");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha podido modificar el usuario " + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca todos los usuarios.
	 * 
	 * @return Una respuesta HTTP que contiene la lista de todos los usuarios
	 */
	@GetMapping("/buscar")
	public ResponseEntity<?> searchAll() {
		try {
			List<UsuarioVO> usuarios = su.findAll();
			return new ResponseEntity<List<UsuarioVO>>(usuarios, HttpStatus.OK);
		} catch (Exception ex) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se han encontrado los usuarios " + ex.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca un usuario por su correo electrónico.
	 * 
	 * @param correo El correo electrónico del usuario a buscar
	 * @return Una respuesta HTTP que contiene el usuario encontrado, si existe
	 */
	@GetMapping("/buscar/{correo}")
	public ResponseEntity<?> searchUserByEmail(@PathVariable String correo) {
		try {
			UsuarioVO usu = su.findByCorreo(correo).get();
			return new ResponseEntity<UsuarioVO>(usu, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "No se ha encontrado ese usuario " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Elimina un usuario existente.
	 * 
	 * @param id El ID del usuario a eliminar
	 * @return Una respuesta HTTP que indica el resultado de la operación de
	 *         eliminación
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			su.delete(su.findById(id).get());
			response.put("message", "Se ha eliminado el usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("message", "No se ha podido eliminar el usuario " + e.getCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
