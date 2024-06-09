package com.dawes.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.UsuarioVO;

/**
 * Repositorio para la entidad {@link UsuarioVO}.
 * 
 * <p>
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * en la entidad UsuarioVO.
 * </p>
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO, Integer> {

	/**
	 * Busca un usuario por correo.
	 * 
	 * @param correo el correo del usuario a buscar.
	 * @return un {@link Optional} que contiene el usuario si se encuentra, o vacío
	 *         si no se encuentra.
	 */
	Optional<UsuarioVO> findByCorreo(String correo);
}
