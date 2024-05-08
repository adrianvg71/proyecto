package com.dawes.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.proyecto.modelo.PreguntaVO;

public interface PreguntaRepository extends JpaRepository<PreguntaVO, Integer> {

}
