package com.dawes.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.UsuarioEjercicioVO;
import com.dawes.proyecto.modelo.UsuarioVO;

/**
 * Repositorio para la entidad {@link UsuarioEjercicioVO}.
 * 
 * <p>
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * en la entidad UsuarioEjercicioVO.
 * </p>
 */
@Repository
public interface UsuarioEjercicioRepository extends JpaRepository<UsuarioEjercicioVO, Integer> {

	/**
	 * Busca una relación usuario-ejercicio por usuario y ejercicio.
	 * 
	 * @param user el usuario.
	 * @param ejer el ejercicio.
	 * @return un {@link Optional} que contiene la relación usuario-ejercicio si
	 *         existe.
	 */
	Optional<UsuarioEjercicioVO> findByUsuarioAndEjercicio(UsuarioVO user, EjercicioVO ejer);

	/**
	 * Busca una lista de relaciones usuario-ejercicio por usuario.
	 * 
	 * @param user el usuario.
	 * @return un {@link Optional} que contiene una lista de relaciones
	 *         usuario-ejercicio asociadas al usuario especificado.
	 */
	Optional<List<UsuarioEjercicioVO>> findByUsuario(UsuarioVO user);
}
