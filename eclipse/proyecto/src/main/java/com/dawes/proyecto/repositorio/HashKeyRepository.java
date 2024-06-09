package com.dawes.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.HashKey;

@Repository
public interface HashKeyRepository extends JpaRepository<HashKey, Integer> {

}
