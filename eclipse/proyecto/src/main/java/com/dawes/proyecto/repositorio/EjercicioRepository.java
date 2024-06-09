package com.dawes.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.EjercicioVO;

<<<<<<< HEAD
@Repository
public interface EjercicioRepository extends JpaRepository<EjercicioVO, Integer> {

=======
/**
 * Repositorio para la entidad {@link EjercicioVO}.
 * 
 * <p>
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * en la entidad EjercicioVO.
 * </p>
 */
@Repository
public interface EjercicioRepository extends JpaRepository<EjercicioVO, Integer> {

	/**
	 * Busca una lista de ejercicios por nivel.
	 * 
	 * @param nivel el nivel de los ejercicios a buscar.
	 * @return un {@link Optional} que contiene una lista de ejercicios con el nivel
	 *         especificado.
	 */
>>>>>>> master
	Optional<List<EjercicioVO>> findByNivel(String nivel);
}
