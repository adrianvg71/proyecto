package com.dawes.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.OpcionVO;

@Repository
public interface OpcionRepository extends JpaRepository<OpcionVO, Integer> {

}
