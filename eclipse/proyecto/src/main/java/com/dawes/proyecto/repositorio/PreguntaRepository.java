package com.dawes.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.PreguntaVO;

/**
 * Repositorio para la entidad {@link PreguntaVO}.
 * 
 * <p>
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * en la entidad PreguntaVO.
 * </p>
 */
@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaVO, Integer> {

	/**
	 * Busca una lista de preguntas por ejercicio.
	 * 
	 * @param ejercicio el ejercicio al que pertenecen las preguntas.
	 * @return un {@link Optional} que contiene una lista de preguntas asociadas al
	 *         ejercicio especificado.
	 */
	Optional<List<PreguntaVO>> findByEjercicio(EjercicioVO ejercicio);
}
