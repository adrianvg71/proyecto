package com.dawes.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.HashKey;

/**
 * Repositorio para la entidad {@link HashKey}.
 * 
 * <p>
 * Proporciona métodos para realizar operaciones CRUD en la entidad HashKey.
 * </p>
 */
@Repository
public interface HashKeyRepository extends JpaRepository<HashKey, Integer> {

}
