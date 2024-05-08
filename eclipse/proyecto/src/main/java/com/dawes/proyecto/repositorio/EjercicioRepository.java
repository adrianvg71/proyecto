package com.dawes.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.proyecto.modelo.EjercicioVO;

public interface EjercicioRepository extends JpaRepository<EjercicioVO, Integer> {

}
