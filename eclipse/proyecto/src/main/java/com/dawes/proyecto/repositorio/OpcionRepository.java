package com.dawes.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.OpcionVO;

/**
 * Repositorio para la entidad {@link OpcionVO}.
 * 
 * <p>
 * Proporciona métodos para realizar operaciones CRUD en la entidad OpcionVO.
 * </p>
 */
@Repository
public interface OpcionRepository extends JpaRepository<OpcionVO, Integer> {

}
